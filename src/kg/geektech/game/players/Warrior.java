package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, Names name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int number = RPG_Game.random.nextInt(3) + 1;
            if (this.getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth((boss.getHealth()+ this.getDamage()) - this.getDamage() * number);
            }
    }
}
