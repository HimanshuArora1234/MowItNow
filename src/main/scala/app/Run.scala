package app

import model._
import service.TondeuseService
/**
 * Scala object that runs the program.
 */
object Run extends App {
	val tondesueService = new TondeuseService
	val pelouse = Pelouse(Coordonnees(5, 5))

	val tendeuse1 = Tondeuse(Coordonnees(1, 2), Direction.N)
	val commands1: Seq[Commande.Value] = Seq(Commande.G, Commande.A, Commande.G, Commande.A, Commande.G, Commande.A, Commande.G, Commande.A, Commande.A)
	val updatesTondeuse1 = commands1.foldLeft(tendeuse1)((accumulator, command)  => tondesueService.moveTondeuse(accumulator, pelouse, command))
	println("New position of tondeuse1 = " + updatesTondeuse1)

	val tendeuse2 = Tondeuse(Coordonnees(3, 3), Direction.E)
	val commands2: Seq[Commande.Value] = Seq(Commande.A, Commande.A, Commande.D, Commande.A, Commande.A, Commande.D, Commande.A, Commande.D, Commande.D, Commande.A)
	val updatesTondeuse2 = commands2.foldLeft(tendeuse1)((accumulator, command)  => tondesueService.moveTondeuse(accumulator, pelouse, command))
	println("New position of tondeuse2 = " + updatesTondeuse2)

}
