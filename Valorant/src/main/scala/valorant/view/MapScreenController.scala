package valorant.view

import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import valorant.MainApp
import valorant.MainApp.game

@sfxml
class MapScreenController {

  def handleBack(action: ActionEvent): Unit = {
    MainApp.showPlayer2Select()
  }

  def handleAscent(action: ActionEvent): Unit = {
    game.map = "/images/Ascent_background.jpg"
    MainApp.showGame()
  }

  def handleBreeze(action: ActionEvent): Unit = {
    game.map = "/images/Breeze_background.jpg"
    MainApp.showGame()
  }

  def handleFracture(action: ActionEvent): Unit = {
    game.map = "/images/Fracture_background.jpg"
    MainApp.showGame()
  }

  def handleHaven(action: ActionEvent): Unit = {
    game.map = "/images/Haven_background.jpg"
    MainApp.showGame()
  }

  def handleIcebox(action: ActionEvent): Unit = {
    game.map = "/images/Icebox_background.jpg"
    MainApp.showGame()
  }

  def handlePearl(action: ActionEvent): Unit = {
    game.map = "/images/Pearl_background.jpg"
    MainApp.showGame()
  }
}
