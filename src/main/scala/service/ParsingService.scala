package service

import java.io.File
import scala.io.Source
import model._


/**
 * Input file parsing service.
 */
class ParsingService {
	//Parses the input file to retrieve the first line and to convert that into Pelous object.
	def getPelous(file: File): Option[Pelouse] = {
		val input = Source.fromFile(file).getLines().toList
		if(!input.isEmpty) {
			val coordinateArray = input(0).split(" ")
			if(coordinateArray.length < 2) None else Some(Pelouse(Coordonnees(coordinateArray(0).toInt, coordinateArray(1).toInt)))
		} else None
	}

	//Parses the input file to retrieve the all the odd lines and to convert them into Tondeuse objects.
	def getTondeuses(file: File): List[Tondeuse] = {
		val input = Source.fromFile(file).getLines().toList
		if(!input.isEmpty && input.length > 1) {
			val tondeuseLines = input.zipWithIndex.filter{
				case (item, index) => index != 0 && index % 2 != 0
			}.map(_._1)
			tondeuseLines.filter(_.split(" ").length == 3).map(line => {
				val tondeuseParams = line.split(" ")
				Tondeuse(Coordonnees(tondeuseParams(0).toInt, tondeuseParams(1).toInt), Direction.withName(tondeuseParams(2)))
			})
		} else List.empty[Tondeuse]

	}

	//Parses the input file to retrieve the all the even lines and to convert them into List of commands.
	def getCommandes(file: File): List[List[Commande.Value]] = {
		val input = Source.fromFile(file).getLines().toList
		if(!input.isEmpty && input.length > 2) {
			val commandLines = input.zipWithIndex.filter{
				case (item, index) => index != 0 && index % 2 == 0
			}.map(_._1)
			commandLines.map(line => line.toList.map(cmd => Commande.withName(cmd.toString)))
		} else List.empty[List[Commande.Value]]
	}

}
