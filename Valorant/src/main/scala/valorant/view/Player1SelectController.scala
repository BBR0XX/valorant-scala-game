package valorant.view

import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import valorant.MainApp
import valorant.MainApp.game
import valorant.model.Player

@sfxml
class Player1SelectController {

  def handleBack(action: ActionEvent): Unit ={
    MainApp.showTitle()
  }

  def handleJett(action: ActionEvent): Unit ={
    game.player1 = new Player("Jett")
    MainApp.showPlayer2Select()
  }

  def handlePhoenix(action: ActionEvent): Unit = {
    game.player1 = new Player("Phoenix")
    MainApp.showPlayer2Select()
  }

  def handleOmen(action: ActionEvent): Unit = {
    game.player1 = new Player("Omen")
    MainApp.showPlayer2Select()
  }

  def handleSage(action: ActionEvent): Unit = {
    game.player1 = new Player("Sage")
    MainApp.showPlayer2Select()
  }

  def handleViper(action: ActionEvent): Unit = {
    game.player1 = new Player("Viper")
    MainApp.showPlayer2Select()
  }

  def handleRaze(action: ActionEvent): Unit = {
    game.player1 = new Player("Raze")
    MainApp.showPlayer2Select()
  }
}
