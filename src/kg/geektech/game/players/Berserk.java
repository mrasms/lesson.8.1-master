package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage, Names name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        if (boss.getDamage() != 0) {
            int number = RPG_Game.random.nextInt(boss.getDamage()) + 1;
            if (boss.getHealth() > 0 && this.getHealth() > 0)
                boss.setHealth(boss.getHealth() - number);
        }
    }
}

