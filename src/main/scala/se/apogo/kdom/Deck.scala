package se.apogo.kdom

import scala.util.Random

object Deck {
  def newDeck(seed: Long, numberOfDominoes: Int): Deck = {
    require(numberOfDominoes <= 48)
    Deck(new Random(seed).shuffle(Dominoes).take(numberOfDominoes))
  }

  private val Dominoes: Seq[Domino] = Seq(
    Domino(1, Tile(Field), Tile(Field)),
    Domino(2, Tile(Field), Tile(Field)),
    Domino(3, Tile(Forest), Tile(Forest)),
    Domino(4, Tile(Forest), Tile(Forest)),
    Domino(5, Tile(Forest), Tile(Forest)),
    Domino(6, Tile(Forest), Tile(Forest)),
    Domino(7, Tile(Water), Tile(Water)),
    Domino(8, Tile(Water), Tile(Water)),
    Domino(9, Tile(Water), Tile(Water)),
    Domino(10, Tile(Pasture), Tile(Pasture)),
    Domino(11, Tile(Pasture), Tile(Pasture)),
    Domino(12, Tile(Clay), Tile(Clay)),
    Domino(13, Tile(Field), Tile(Forest)),
    Domino(14, Tile(Field), Tile(Water)),
    Domino(15, Tile(Field), Tile(Pasture)),
    Domino(16, Tile(Field), Tile(Clay)),
    Domino(17, Tile(Forest), Tile(Water)),
    Domino(18, Tile(Forest), Tile(Pasture)),
    Domino(19, Tile(Field, 1), Tile(Forest)),
    Domino(20, Tile(Field, 1), Tile(Water)),
    Domino(21, Tile(Field, 1), Tile(Pasture)),
    Domino(22, Tile(Field, 1), Tile(Clay)),
    Domino(23, Tile(Field, 1), Tile(Mine)),
    Domino(24, Tile(Forest, 1), Tile(Field)),
    Domino(25, Tile(Forest, 1), Tile(Field)),
    Domino(26, Tile(Forest, 1), Tile(Field)),
    Domino(27, Tile(Forest, 1), Tile(Field)),
    Domino(28, Tile(Forest, 1), Tile(Water)),
    Domino(29, Tile(Forest, 1), Tile(Pasture)),
    Domino(30, Tile(Water, 1), Tile(Field)),
    Domino(31, Tile(Water, 1), Tile(Field)),
    Domino(32, Tile(Water, 1), Tile(Forest)),
    Domino(33, Tile(Water, 1), Tile(Forest)),
    Domino(34, Tile(Water, 1), Tile(Forest)),
    Domino(35, Tile(Water, 1), Tile(Forest)),
    Domino(36, Tile(Field), Tile(Pasture, 1)),
    Domino(37, Tile(Water), Tile(Pasture, 1)),
    Domino(38, Tile(Field), Tile(Clay, 1)),
    Domino(39, Tile(Pasture), Tile(Clay, 1)),
    Domino(40, Tile(Mine, 1), Tile(Field)),
    Domino(41, Tile(Field), Tile(Pasture, 2)),
    Domino(42, Tile(Water), Tile(Pasture, 2)),
    Domino(43, Tile(Field), Tile(Clay, 2)),
    Domino(44, Tile(Pasture), Tile(Clay, 2)),
    Domino(45, Tile(Mine, 2), Tile(Field)),
    Domino(46, Tile(Clay), Tile(Mine, 2)),
    Domino(47, Tile(Clay), Tile(Mine, 2)),
    Domino(48, Tile(Field), Tile(Mine, 3))
  )
}
case class Deck(dominoes: Seq[Domino]) {
  require(dominoes.distinct == dominoes)

  def draft(n: Int): (Deck, Draft) = {
    require(dominoes.size >= n)

    (Deck(dominoes.drop(n)), Draft(dominoes.take(n).toSet, Map()))
  }

  def isEmpty: Boolean = dominoes.isEmpty
}

