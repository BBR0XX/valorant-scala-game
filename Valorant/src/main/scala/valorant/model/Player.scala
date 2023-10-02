package valorant.model

class Player(val name: String){
  val maxHealth: Double = 300
  var health: Double = 300
  val meleeWeapon: Weapon = new Knife
  var primaryWeapon: Gun = new Spectre {}
  var sidearm: Gun = new Classic {}
  var lost: Boolean = false
  var credits: Int = 500

  def meleeAttack(weapon: Weapon, opponent: Player): Unit = {
    var damage: Int = weapon.damage
    opponent.health -= damage

    if (opponent.health <= 0) {
      opponent.health = 0
      opponent.lose()
    }
  }

  def gunAttack(weapon: Gun, opponent: Player): Unit = {
    var damage: Int = weapon.damage
    opponent.health -= damage
    weapon.ammo -= 1

    if (opponent.health <=0) {
      opponent.health = 0
      opponent.lose()
    }
  }

  def lose(): Unit = {
    this.lost = true
  }

}

