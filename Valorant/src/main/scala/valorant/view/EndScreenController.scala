package valorant.view

import scalafx.event.ActionEvent
import scalafx.scene.control.Label
import scalafx.scene.image.{Image, ImageView}
import scalafxml.core.macros.sfxml
import valorant.MainApp
import valorant.MainApp.game

@sfxml
class EndScreenController (
                          private var winnerIcon: ImageView,
                          private var winnerText: Label
                          ){
  winnerIcon.image = new Image(getClass.getResourceAsStream("/images/" + game.winner.name + "_icon.png"))
  winnerText.text = game.gameStatus

  def handleReturn(action: ActionEvent): Unit = {
    MainApp.showTitle()
  }
}
