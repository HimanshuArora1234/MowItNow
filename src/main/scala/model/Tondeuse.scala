package model

/**
 * Data model for Tondeuse.
 * @param coordonnees Current coordinates
 * @param direction Current direction
 * @author Himanshu Arora
 */
case class Tondeuse (coordonnees: Coordonnees, direction: Direction.Value) {
	def print = this.coordonnees.x + " " + this.coordonnees.y + " " + this.direction.toString
}

