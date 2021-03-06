package view


import model.Tondeuse

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.{Alert, Hyperlink}
import scalafx.scene.image.Image
import scalafx.scene.layout.StackPane
import scalafx.stage.FileChooser

import service._
/**
 * ScalaFX GUI object to run the MowItNow application.
 * @author Himanshu Arora
 */
object MowGuiRunner extends JFXApp {
	stage = new JFXApp.PrimaryStage {
		title.value = "MowItNow"
		width = 600
		height = 450
	}
	stage.getIcons.add(new Image(this.getClass.getResourceAsStream("/images/mower.png")))
	val rootPane = new StackPane()
	rootPane.setId("root")
	val scene = new Scene(rootPane)
	scene.getStylesheets.add(this.getClass().getResource("/css/style.css").toExternalForm())
	stage.scene= scene

	val chooseLink = new Hyperlink("CHOOSE AN INPUT FILE")
	chooseLink.setId("link")
	chooseLink.onAction = (e: ActionEvent) => {
		val fileChooser = new FileChooser() {title = "Pick an input file"}
		val inputFile = fileChooser.showOpenDialog(stage)
		if(inputFile != null) {
			val fileParseService = new ParsingService()
			val mayBePelouse = fileParseService.getPelous(inputFile)
			mayBePelouse match {
				case Some(pelouse) =>
					val tondeuses = fileParseService.getTondeuses(inputFile)
					val commandes = fileParseService.getCommandes(inputFile)
					tondeuses.zipWithIndex.map {
					case (tondeuse, index) if(commandes.length >= index + 1) => { //When there is a list of command for the tondeuse
						val tondeuseService = new TondeuseService()
						val movedTondeuse = commandes(index).foldLeft(tondeuse)((accumulator, command)  => tondeuseService.moveTondeuse(accumulator, pelouse, command))
						GuiHelper.showPosition(movedTondeuse, index)
					}
					case (tondeuse, index) => GuiHelper.showPosition(tondeuse, index) //No command to be executed on the tondeuse
				}
				case None => new Alert(AlertType.Error) {
					title = "Error"
					headerText = "No pelouse coordiantes found"
					contentText = "Provide a valide input file"
				}.showAndWait
			}

		}
	}
	rootPane.children.add(chooseLink)
}

object GuiHelper {
	//Displays a Info dialog box containing the position of a tondeuse.
	def showPosition(tondeuse: Tondeuse, index: Int) = {
		new Alert(AlertType.Information) {
			title = "Output"
			headerText = "Final position of tondeuse " + (index + 1)
			contentText = tondeuse.print
		}.showAndWait
	}
}
