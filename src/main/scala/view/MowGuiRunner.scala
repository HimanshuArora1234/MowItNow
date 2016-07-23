package view

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

/**
 * ScalaFX GUI object to run the MowItNow application.
 */
object MowGuiRunner extends JFXApp {
	stage = new JFXApp.PrimaryStage {
		title.value = "MowItNow"
		width = 600
		height = 450
		scene = new Scene() {
			fill = LightGreen
		}
	}
	stage.getIcons.add(new Image(this.getClass.getResourceAsStream("/images/mower.png")))
}
