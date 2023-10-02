package valorant.model

import scalafx.beans.property.BooleanProperty

import java.util.Scanner
import scala.util.Random

class Game(){
  var player1: Player = null
  var player2: Player = null
  var turn: Boolean = false
  var gameEnd: Boolean = false
  var gameStatus: String = ""
  var map: String = ""

  def nextTurn(): Unit = {
    turn = !turn
  }

  def gameProgress(): Unit = {
    if (player1.lost == true || player2.lost == true) {
      gameEnd = true
      gameStatus = winner.name + " is victorious!"
    } else {
      nextTurn()
    }
  }

  def winner: Player = {
    if (player1.lost) {
      player2
    } else if (player2.lost) {
      player1
    } else {
      null
    }
  }
}