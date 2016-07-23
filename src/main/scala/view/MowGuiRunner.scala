package view



import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.Hyperlink
import scalafx.scene.image.Image
import scalafx.scene.layout.StackPane
import scalafx.stage.FileChooser

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
	}
	rootPane.children.add(chooseLink)
}
