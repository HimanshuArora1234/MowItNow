package model

/**
 * Direction constants.
 * N represents North.
 * E represents East.
 * W represents West.
 * S represents South.
 */
object Direction extends Enumeration {
  val N, E, W, S = Value
}

/**
 * Command constants.
 * D to turn 90 deg to right.
 * G to turn 90 deg to left.
 * A to move forward one step.
 */
object Commande extends Enumeration {
  val D, G, A = Value
}