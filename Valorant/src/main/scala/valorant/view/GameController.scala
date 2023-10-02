package valorant.view

import scalafx.event.ActionEvent
import scalafx.scene.control.{Label, ProgressBar, ProgressIndicator}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.GridPane
import scalafx.scene.text.Text
import scalafxml.core.macros.sfxml
import valorant.MainApp
import valorant.MainApp.game
import scala.util.Random

@sfxml
class GameController (
                       private val player1Image : ImageView,
                       private var player2Image: ImageView,
                       private var backgroundImage: ImageView,
                       private var hpPlayer1: ProgressBar,
                       private var hpPlayer2: ProgressBar,
                       private var hpPlayer1Text: Label,
                       private var hpPlayer2Text: Label,
                       private val player1Name: Label,
                       private var player2Name: Label,
                       private var gridPanePlayer: GridPane,
                       private var gridPaneEnemy: GridPane,
                       private var meleePlayer1Image: ImageView,
                       private var primaryPlayer1Image: ImageView,
                       private var primaryAmmoPlayer1Text: Label,
                       private var sidearmPlayer1Image: ImageView,
                       private var sidearmAmmoPlayer1Text: Label,
                       private var shopPlayer1Image: ImageView,
                       private var meleePlayer2Image: ImageView,
                       private var primaryPlayer2Image: ImageView,
                       private var primaryAmmoPlayer2Text: Label,
                       private var sidearmPlayer2Image: ImageView,
                       private var sidearmAmmoPlayer2Text: Label,
                       private var shopPlayer2Image: ImageView,
                       private var consoleText: Text,
                       private var bonusText: Text
) {
  backgroundImage.image = new Image(getClass.getResourceAsStream(game.map))
  shopPlayer1Image.image = new Image(getClass.getResourceAsStream("/images/Shop.png"))
  shopPlayer2Image.image = new Image(getClass.getResourceAsStream("/images/Shop.png"))

  consoleText.text = ""
  bonusText.text = ""
  player1Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player1.name + ".png"))
  player2Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player2.name + ".png"))
  player1Name.text = game.player1.name
  player2Name.text = game.player2.name
  updateHealthBar(game.player1.health, game.player1.maxHealth, hpPlayer1, hpPlayer1Text)
  updateHealthBar(game.player2.health, game.player2.maxHealth, hpPlayer2, hpPlayer2Text)
  meleePlayer1Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player1.meleeWeapon.name + ".png"))
  primaryPlayer1Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player1.primaryWeapon.name + ".png"))
  sidearmPlayer1Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player1.sidearm.name + ".png"))
  meleePlayer2Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player2.meleeWeapon.name + ".png"))
  primaryPlayer2Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player2.primaryWeapon.name + ".png"))
  sidearmPlayer2Image.image = new Image(getClass.getResourceAsStream("/images/" + game.player2.sidearm.name + ".png"))
  primaryAmmoPlayer1Text.text = "Ammo: " + game.player1.primaryWeapon.ammo + "/" + game.player1.primaryWeapon.maxAmmo
  sidearmAmmoPlayer1Text.text = "Ammo: " + game.player1.sidearm.ammo + "/" + game.player1.sidearm.maxAmmo
  primaryAmmoPlayer2Text.text = "Ammo: " + game.player2.primaryWeapon.ammo + "/" + game.player2.primaryWeapon.maxAmmo
  sidearmAmmoPlayer2Text.text = "Ammo: " + game.player2.sidearm.ammo + "/" + game.player2.sidearm.maxAmmo

  disableGridPane()

  def disableGridPane(): Unit = {
    if (game.turn == false) {
      gridPanePlayer.disable = false
      gridPaneEnemy.disable = true
    } else {
      gridPanePlayer.disable = true
      gridPaneEnemy.disable = false
    }
  }

  def endRound(): Unit ={
    if (game.gameEnd == true) {
      MainApp.showEndScreen()
    }
  }

  //Health bar
  def updateHealthBar(health: Double, maxHealth: Double, healthBar: ProgressIndicator, healthText: Label): Unit ={
    val healthValue = health/maxHealth
    healthBar.progress = healthValue
    healthText.text = health.toInt.toString + " HP"
  }

  //Player 1 buttons
  def handleMeleePlayer1(action: ActionEvent): Unit ={
    game.player1.meleeAttack(game.player1.meleeWeapon, game.player2)
    updateHealthBar(game.player2.health, game.player2.maxHealth, hpPlayer2, hpPlayer2Text)
    consoleText.text = game.player1.name + " did " + game.player1.meleeWeapon.damage + " damage!"
    game.gameProgress()
    disableGridPane()
    endRound()
  }

  def handlePrimaryPlayer1(action: ActionEvent): Unit ={
    if (game.player1.primaryWeapon.ammo != 0) {
      game.player1.gunAttack(game.player1.primaryWeapon, game.player2)
      updateHealthBar(game.player2.health, game.player2.maxHealth, hpPlayer2, hpPlayer2Text)
      primaryAmmoPlayer1Text.text = "Ammo: " + game.player1.primaryWeapon.ammo + "/" + game.player1.primaryWeapon.maxAmmo
      if (game.player1.primaryWeapon.damage == game.player1.primaryWeapon.criticalHit){
        game.player1.credits += 50
        consoleText.text = "Critical hit! " + game.player1.name + " did " + game.player1.primaryWeapon.damage + " damage!"
        bonusText.text = "Bonus 50 credits!"
      } else {
        consoleText.text = game.player1.name + " did " + game.player1.primaryWeapon.damage + " damage!"
        bonusText.text = ""
      }
      game.player1.primaryWeapon.damage = Random.shuffle(game.player1.primaryWeapon.damageValues.toList).head
      game.gameProgress()
      disableGridPane()
      endRound()
    } else {
      consoleText.text = "Weapon has no ammo!"
      bonusText.text = ""
    }
  }

  def handleSidearmPlayer1(action: ActionEvent): Unit ={
    if (game.player1.sidearm.ammo != 0) {
      game.player1.gunAttack(game.player1.sidearm, game.player2)
      updateHealthBar(game.player2.health, game.player2.maxHealth, hpPlayer2, hpPlayer2Text)
      sidearmAmmoPlayer1Text.text = "Ammo: " + game.player1.sidearm.ammo + "/" + game.player1.sidearm.maxAmmo
      if (game.player1.sidearm.damage == game.player1.sidearm.criticalHit) {
        game.player1.credits += 50
        consoleText.text = "Critical hit! " + game.player1.name + " did " + game.player1.sidearm.damage + " damage!"
        bonusText.text = "Bonus 50 credits!"
      } else {
        consoleText.text = game.player1.name + " did " + game.player1.sidearm.damage + " damage!"
        bonusText.text = ""
      }
      game.player1.sidearm.damage = Random.shuffle(game.player1.sidearm.damageValues.toList).head
      game.gameProgress()
      disableGridPane()
      endRound()
    } else {
      consoleText.text = "Weapon has no ammo!"
      bonusText.text = ""
    }
  }

  def handleShopPlayer1(action: ActionEvent): Unit ={
    MainApp.showShopPlayer1Dialog(game)
  }

  //Player 2 buttons
  def handleMeleePlayer2(action: ActionEvent): Unit = {
    game.player2.meleeAttack(game.player2.meleeWeapon, game.player1)
    updateHealthBar(game.player1.health, game.player1.maxHealth, hpPlayer1, hpPlayer1Text)
    consoleText.text = game.player2.name + " did " + game.player2.meleeWeapon.damage + " damage!"
    game.gameProgress()
    disableGridPane()
    endRound()
  }

  def handlePrimaryPlayer2(action: ActionEvent): Unit = {
    if (game.player2.primaryWeapon.ammo != 0) {
      game.player2.gunAttack(game.player2.primaryWeapon, game.player1)
      updateHealthBar(game.player1.health, game.player1.maxHealth, hpPlayer1, hpPlayer1Text)
      primaryAmmoPlayer2Text.text = "Ammo: " + game.player2.primaryWeapon.ammo + "/" + game.player2.primaryWeapon.maxAmmo
      if (game.player2.primaryWeapon.damage == game.player2.primaryWeapon.criticalHit) {
        game.player2.credits += 50
        consoleText.text = "Critical hit! " + game.player2.name + " did " + game.player2.primaryWeapon.damage + " damage!"
        bonusText.text = "Bonus 50 credits!"
      } else {
        consoleText.text = game.player2.name + " did " + game.player2.primaryWeapon.damage + " damage!"
        bonusText.text = ""
      }
      game.player2.primaryWeapon.damage = Random.shuffle(game.player2.primaryWeapon.damageValues.toList).head
      game.gameProgress()
      disableGridPane()
      endRound()
    } else {
      consoleText.text = "Weapon has no ammo!"
      bonusText.text = ""
    }
  }

  def handleSidearmPlayer2(action: ActionEvent): Unit = {
    if (game.player2.sidearm.ammo != 0) {
      game.player2.gunAttack(game.player2.sidearm, game.player1)
      updateHealthBar(game.player1.health, game.player1.maxHealth, hpPlayer1, hpPlayer1Text)
      sidearmAmmoPlayer1Text.text = "Ammo: " + game.player2.sidearm.ammo + "/" + game.player2.sidearm.maxAmmo
      if (game.player2.sidearm.damage == game.player2.sidearm.criticalHit) {
        game.player2.credits += 50
        consoleText.text = "Critical hit! " + game.player2.name + " did " + game.player2.sidearm.damage + " damage!"
        bonusText.text = "Bonus 50 credits!"
      } else {
        consoleText.text = game.player2.name + " did " + game.player2.sidearm.damage + " damage!"
        bonusText.text = ""
      }
      game.player2.sidearm.damage = Random.shuffle(game.player2.sidearm.damageValues.toList).head
      game.gameProgress()
      disableGridPane()
      endRound()
    } else {
      consoleText.text = "Weapon has no ammo!"
      bonusText.text = ""
    }
  }

  def handleShopPlayer2(action: ActionEvent): Unit = {
    MainApp.showShopPlayer2Dialog(game)
  }

}
