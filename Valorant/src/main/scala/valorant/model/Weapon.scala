package valorant.model

import scala.util.Random

abstract class Weapon {
  val name: String
  var damage: Int
}

abstract class Gun extends Weapon {
  var ammo: Int
  var maxAmmo: Int
  val damageValues: Array[Int]
  val criticalHit: Int
}

class Knife extends Weapon {
  val name = "Knife"
  var damage = 5
}

class Classic extends Gun {
  val name = Classic.name
  var ammo = 15
  var maxAmmo = ammo
  val damageValues = Array(7,8,9,10)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Classic {
  val name = "Classic"
  val cost: Int = 30
}

class Shorty extends Gun {
  val name = Shorty.name
  var ammo = 10
  var maxAmmo = ammo
  val damageValues = Array(5,6,7,8,9,10,11,12,13,14,15)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Shorty {
  val name = "Shorty"
  val cost: Int = 50
}

class Frenzy extends Gun {
  val name = Frenzy.name
  var ammo = 12
  var maxAmmo = ammo
  val damageValues = Array(7,8)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Frenzy {
  val name = "Frenzy"
  val cost: Int = 40
}

class Sheriff extends Gun {
  val name = Sheriff.name
  var ammo = 6
  var maxAmmo = ammo
  val damageValues = Array(10,11,12)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Sheriff {
  val name = "Sheriff"
  val cost: Int = 80
}

class Spectre extends Gun {
  val name = Spectre.name
  var ammo = 12
  var maxAmmo = ammo
  val damageValues = Array(12, 13, 14, 15,16,17,18,19,20)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Spectre {
  val name = "Spectre"
  val cost: Int = 160
}

class Vandal extends Gun {
  val name = Vandal.name
  var ammo = 8
  var maxAmmo = ammo
  val damageValues = Array(18,19,20,21,22,23,24,25)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Vandal {
  val name = "Vandal"
  val cost: Int = 290
}

class Operator extends Gun {
  val name = Operator.name
  var ammo = 5
  var maxAmmo = ammo
  val damageValues = Array(27,28,29,30)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Operator {
  val name = "Operator"
  val cost: Int = 470
}

class Odin extends Gun {
  val name = Odin.name
  var ammo = 18
  var maxAmmo = ammo
  val damageValues = Array(14, 15, 16, 17,18,19,20,21,22)
  val criticalHit = damageValues.last
  var damage = Random.shuffle(damageValues.toList).head
}

object Odin {
  val name = "Odin"
  val cost: Int = 320
}