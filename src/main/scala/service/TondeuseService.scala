package service

import model._

/**
 * Created by arorah on 22/07/2016.
 */
class TondeuseService {
	/**
	 * This service computes the new position of Tondeuse in the pelouse and returns a new Tondeuse object with updated position.
	 * @param inputTondeuse
	 * @param pelouse
	 * @param commande
	 * @return New Tondeuse object updated with after the execution of commande on inputTondeuse
	 */
	def moveTondeuse(inputTondeuse: Tondeuse, pelouse: Pelouse, commande: Commande.Value): Tondeuse = {
		commande match {
			case Commande.G => inputTondeuse.copy(direction = leftRight(inputTondeuse.direction)._1)
			case Commande.D => inputTondeuse.copy(direction = leftRight(inputTondeuse.direction)._2)
			case Commande.A => {
				val newCoordinates = computeCoordinates(inputTondeuse.coordonnees, inputTondeuse.direction)
				//Check if new coordinates are in the pelous
				if(newCoordinates.x >= 0 && newCoordinates.y >= 0 && newCoordinates.x <= pelouse.superieurDroit.x && newCoordinates.y <= pelouse.superieurDroit.y)
					inputTondeuse.copy(coordonnees = newCoordinates) else inputTondeuse
			}
		}
	}
	//Helper function to return the tuple of directions obtained by rotating the tondeuse 90 deg left and right from current direction
	private def leftRight(currentDirection: Direction.Value): (Direction.Value, Direction.Value) = currentDirection match {
		case Direction.N => (Direction.W, Direction.E)
		case Direction.E => (Direction.N, Direction.S)
		case Direction.S => (Direction.E, Direction.W)
		case Direction.W => (Direction.S, Direction.N)
	}
	//Computes the new coordinates using the current coordiante and direction of tondeuse
	private def computeCoordinates(currentCoordinates: Coordonnees, currentDirection: Direction.Value): Coordonnees = currentDirection match {
		case Direction.N => currentCoordinates.copy(y = currentCoordinates.y + 1)
		case Direction.E => currentCoordinates.copy(x = currentCoordinates.x + 1)
		case Direction.S => currentCoordinates.copy(y = currentCoordinates.y - 1)
		case Direction.W => currentCoordinates.copy(x = currentCoordinates.x - 1)
	}
}
