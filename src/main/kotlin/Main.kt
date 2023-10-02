fun main() {
    val player = Player(20, 10, 100, 5..10)
    val monster = Monster(15, 5, 80, 3..8)

    while (player.isAlive() && monster.isAlive()) {
        val playerDamage = player.attackTarget(monster)
        println("Игрок наносит $playerDamage урона монстру. Здоровье монстра: ${monster.health}")

        if (monster.isAlive()) {
            val monsterDamage = monster.attackTarget(player)
            println("Монстр наносит $monsterDamage урона игроку. Здоровье игрока: ${player.health}")
        }
    }

    if (player.isAlive()) {
        println("Игрок победил!")
    } else {
        println("Монстр победил!")
    }
}