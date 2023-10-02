import kotlin.random.Random
import kotlin.random.nextInt

open class Creature(val attack: Int, val defense: Int, var health: Int, val damageRange: IntRange) {
    init {
        require(attack in 1..30 && defense in 1..30 && health >= 0) { "Некорректные параметры существа" }
    }

    fun isAlive() = health > 0

    fun takeDamage(damage: Int) {
        require(damage >= 0) { "Урон должен быть натуральным числом" }
        health -= damage
        if (health < 0) health = 0
    }

    fun attackTarget(target: Creature): Int {
        require(target is Creature) { "Цель должна быть существом" }

        val attackModifier = attack - target.defense + 1
        val numDiceRolls = maxOf(1, attackModifier)
        val diceRolls = List(numDiceRolls) { Random.nextInt(1, 7) }

        return if (5 in diceRolls || 6 in diceRolls) {
            val damage = Random.nextInt(damageRange)
            target.takeDamage(damage)
            damage
        } else {
            0
        }
    }
}