package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Golem extends Hero {
    public Golem(int health, int damage, Names name) {
        super(health, damage, SuperAbility.BLOCK, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
            if (boss.getHealth() > 0 && boss.getDamage() !=0 && this.getHealth() > 0){
                this.setHealth((this.getHealth() -  ((boss.getDamage() / 5) * (RPG_Game.getAliveHeroes()-1))));
                boss.setDamage((boss.getDamage()/5) * 4); //RPG_Game.getAliveHeroes()-1);
            } else boss.setDamage(50);
        }
    }

