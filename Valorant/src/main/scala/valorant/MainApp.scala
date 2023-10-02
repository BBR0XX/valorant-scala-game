package valorant

import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.Image
import scalafx.stage.{Modality, Stage}
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import valorant.model.Game
import valorant.view.{ShopPlayer1DialogController, ShopPlayer2DialogController}


object MainApp extends JFXApp {
  var game: Game = null
  val rootResource = getClass.getResource("/view/RootLayout.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  // initialize stage
    stage = new PrimaryStage {
      title = "Valorant"
      icons += new Image(getClass().getResourceAsStream("/images/Valorant_logo.png"))
      scene = new Scene {
        root = roots
      }
  }

  def showTitle(): Unit = {
    val resource = getClass.getResource("/view/TitleScreen.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
  showTitle()

  def showPlayer1Select(): Unit = {
    game = new Game()
    val resource = getClass.getResource ("/view/Player1SelectScreen.fxml")
    val loader = new FXMLLoader (resource, NoDependencyResolver)
    loader.load ();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter (roots)
  }

  def showPlayer2Select(): Unit = {
    val resource = getClass.getResource("/view/Player2SelectScreen.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showMap(): Unit ={
    val resource = getClass.getResource("/view/MapScreen.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showGame(): Unit ={
    val resource = getClass.getResource("/view/GameScreen.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showShopPlayer1Dialog(game: Game): Unit ={
    val resource = getClass.getResourceAsStream("/view/ShopPlayer1Dialog.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[ShopPlayer1DialogController#Controller]

    val dialog = new Stage() {
      initModality(Modality.APPLICATION_MODAL)
      initOwner(stage)
      scene = new Scene {
        title = "Player 1 Shop"
        icons += new Image(getClass().getResourceAsStream("/images/Shop.png"))
        root = roots2
      }
    }
    control.dialogStage = dialog
    control.game = game
    dialog.showAndWait()
  }

  def showShopPlayer2Dialog(game: Game): Unit = {
    val resource = getClass.getResourceAsStream("/view/ShopPlayer2Dialog.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots2 = loader.getRoot[jfxs.Parent]
    val control = loader.getController[ShopPlayer2DialogController#Controller]

    val dialog = new Stage() {
      initModality(Modality.APPLICATION_MODAL)
      initOwner(stage)
      scene = new Scene {
        title = "Player 2 Shop"
        icons += new Image(getClass().getResourceAsStream("/images/Shop.png"))
        root = roots2
      }
    }
    control.dialogStage = dialog
    control.game = game
    dialog.showAndWait()
  }

  def showEndScreen(): Unit = {
    val resource = getClass.getResource("/view/EndScreen.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }
}

