class Player(
    attack: Int,
    defense: Int,
    health: Int,
    damageRange: IntRange,
    private val maxHealUses: Int = 4,
    private val healPercentage: Int = 30,
    ) : Creature(attack, defense, health, damageRange) {
    private var healUses = 0

    fun heal() {
        if (healUses < maxHealUses) {
            val healAmount = (health * healPercentage) / 100
            health += healAmount
            if (health > 100) health = 100
            healUses++
        }
    }
}