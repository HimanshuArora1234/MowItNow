package view


import javax.smartcardio.CommandAPDU

import model.{Tondeuse, Commande}

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
			val tondeuseService = new TondeuseService()
			val pelouse = fileParseService.getPelous(inputFile)
			val tondeuses = fileParseService.getTondeuses(inputFile)
			val commandes = fileParseService.getCommandes(inputFile)
			pelouse match {
				case Some(p) =>
					tondeuses.zipWithIndex.map {
					case (tondeuse, index) if(commandes.length >= index + 1) => {
						val movedTondeuse = commandes(index).foldLeft(tondeuse)((accumulator, command)  => tondeuseService.moveTondeuse(accumulator, p, command))
						new Alert(AlertType.Information) {
							title = "Output"
							headerText = "Position of tondeuse " + (index + 1)
							contentText = movedTondeuse.print
						}.showAndWait
					}
				}
				case None => new Alert(AlertType.Error) {
					title = "Error"
					headerText = "No pelouse coodiantes found"
					contentText = "Provide a valide input file"
				}.showAndWait
			}

		}
	}
	rootPane.children.add(chooseLink)
}
