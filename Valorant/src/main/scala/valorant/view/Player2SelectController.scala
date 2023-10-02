package valorant.view

import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import valorant.MainApp
import valorant.MainApp.game
import valorant.model.Player

@sfxml
class Player2SelectController {

  def handleBack(action: ActionEvent): Unit = {
    MainApp.showPlayer1Select()
  }

  def handleJett(action: ActionEvent): Unit = {
    game.player2 = new Player("Jett")
    MainApp.showMap()
  }

  def handlePhoenix(action: ActionEvent): Unit = {
    game.player2 = new Player("Phoenix")
    MainApp.showMap()
  }

  def handleOmen(action: ActionEvent): Unit = {
    game.player2 = new Player("Omen")
    MainApp.showMap()
  }

  def handleSage(action: ActionEvent): Unit = {
    game.player2 = new Player("Sage")
    MainApp.showMap()
  }

  def handleViper(action: ActionEvent): Unit = {
    game.player2 = new Player("Viper")
    MainApp.showMap()
  }

  def handleRaze(action: ActionEvent): Unit = {
    game.player2 = new Player("Raze")
    MainApp.showMap()
  }
}
