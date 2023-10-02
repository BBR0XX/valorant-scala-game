package valorant.view

import scalafx.event.ActionEvent
import scalafx.scene.control.{Alert, Label}
import scalafx.scene.image.{Image, ImageView}
import scalafx.stage.Stage
import scalafxml.core.macros.sfxml
import valorant.MainApp
import valorant.model._

@sfxml
class ShopPlayer2DialogController(
                                   private val classicImage: ImageView,
                                   private val shortyImage: ImageView,
                                   private val frenzyImage: ImageView,
                                   private val sheriffImage: ImageView,
                                   private val spectreImage: ImageView,
                                   private val vandalImage: ImageView,
                                   private val odinImage: ImageView,
                                   private val operatorImage: ImageView,
                                   private val classicText: Label,
                                   private val shortyText: Label,
                                   private val frenzyText: Label,
                                   private val sheriffText: Label,
                                   private val spectreText: Label,
                                   private val vandalText: Label,
                                   private val odinText: Label,
                                   private val operatorText: Label,
                                   private var player2CreditsText: Label
                                 ) {
  var dialogStage: Stage = null
  private var _game: Game = null
  def game = _game
  def game_=(x : Game) {
    _game = x
    player2CreditsText.text = "Credits: $" + _game.player2.credits
  }
  classicImage.image = new Image(getClass.getResourceAsStream("/images/Classic_shop.png"))
  shortyImage.image = new Image(getClass.getResourceAsStream("/images/Shorty_shop.png"))
  frenzyImage.image = new Image(getClass.getResourceAsStream("/images/Frenzy_shop.png"))
  sheriffImage.image = new Image(getClass.getResourceAsStream("/images/Sheriff_shop.png"))
  spectreImage.image = new Image(getClass.getResourceAsStream("/images/Spectre_shop.png"))
  vandalImage.image = new Image(getClass.getResourceAsStream("/images/Vandal_shop.png"))
  odinImage.image = new Image(getClass.getResourceAsStream("/images/Odin_shop.png"))
  operatorImage.image = new Image(getClass.getResourceAsStream("/images/Operator_shop.png"))

  classicText.text = Classic.name + " $" + Classic.cost
  shortyText.text = Shorty.name + " $" + Shorty.cost
  frenzyText.text = Frenzy.name + " $" + Frenzy.cost
  sheriffText.text = Sheriff.name + " $" + Sheriff.cost
  spectreText.text = Spectre.name + " $" + Spectre.cost
  vandalText.text = Vandal.name + " $" + Vandal.cost
  odinText.text = Odin.name + " $" + Odin.cost
  operatorText.text = Operator.name + " $" + Operator.cost

  def handleCancel(action: ActionEvent): Unit ={
    MainApp.showGame()
    dialogStage.close()
  }

  def handleClassic (action: ActionEvent): Unit ={
    if (_game.player2.credits < Classic.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.sidearm = new Classic {}
      _game.player2.credits -= Classic.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }

  def handleShorty(action: ActionEvent): Unit = {
    if (_game.player2.credits < Shorty.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.sidearm = new Shorty {}
      _game.player2.credits -= Shorty.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }

  def handleFrenzy(action: ActionEvent): Unit = {
    if (_game.player2.credits < Frenzy.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.sidearm = new Frenzy {}
      _game.player2.credits -= Frenzy.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }

  def handleSheriff(action: ActionEvent): Unit = {
    if (_game.player2.credits < Sheriff.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.sidearm = new Sheriff {}
      _game.player2.credits -= Sheriff.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }

  def handleSpectre(action: ActionEvent): Unit = {
    if (_game.player2.credits < Spectre.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.primaryWeapon = new Spectre {}
      _game.player2.credits -= Spectre.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }

  def handleVandal(action: ActionEvent): Unit = {
    if (_game.player2.credits < Vandal.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.primaryWeapon = new Vandal {}
      _game.player2.credits -= Vandal.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }

  def handleOdin(action: ActionEvent): Unit = {
    if (_game.player2.credits < Odin.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.primaryWeapon = new Odin {}
      _game.player2.credits -= Odin.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }

  def handleOperator(action: ActionEvent): Unit = {
    if (_game.player2.credits < Operator.cost) {
      val alert = new Alert(Alert.AlertType.Warning) {
        initOwner(MainApp.stage)
        title = "Warning"
        headerText = "Not enough credits!"
        contentText = "Select a different weapon."
      }.showAndWait()
    } else {
      _game.player2.primaryWeapon = new Operator {}
      _game.player2.credits -= Operator.cost
      player2CreditsText.text = "Credits: $" + _game.player2.credits
    }
  }


}
