package model

/**
 * Created by arorah on 22/07/2016.
 */
case class Tondeuse (coordonnees: Coordonnees, direction: Direction.Value) {
	def print = this.coordonnees.x + " " + this.coordonnees.y + " " + this.direction.toString
}

