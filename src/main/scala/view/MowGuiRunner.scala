package view

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafx.scene.layout.StackPane
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.stage.StageStyle

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
}
