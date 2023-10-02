package valorant.view

import scalafx.event.ActionEvent
import scalafx.scene.image.{Image, ImageView}
import scalafxml.core.macros.sfxml
import valorant.MainApp

@sfxml
class TitleController (private val titleBackground: ImageView){
  titleBackground.image = new Image(getClass.getResourceAsStream("/images/TitleBackground.png"))

  def handlePlay (action: ActionEvent): Unit = {
    MainApp.showPlayer1Select()
  }

  def handleExit (action: ActionEvent): Unit = {
    System.exit(0)
  }

}


