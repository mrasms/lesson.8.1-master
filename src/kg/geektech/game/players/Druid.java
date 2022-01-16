package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class Druid extends Hero {
    public Druid(int health, int damage, Names name) {
        super(health, damage, SuperAbility.CALL, name);
    }
    private static int druidsAbilityWasUsed;
    // private static int druidCall;

    private static void druidsAbility(){
        if (druidWillHit()==1){
            druidsAbilityWasUsed++;
        }
    }
    private static int druidWillHit() {
        Random hit = new Random();
        boolean hitDruid = hit.nextBoolean();
        if (hitDruid) {
            return 1;
        } else return 0;
    }
    private static int whoWillCall() {
        Random hit = new Random();
        boolean hitDruid = hit.nextBoolean();
        if (hitDruid) {
            return 1;
        } else return 0;
    }
    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        druidsAbility();
        whoWillCall(); // если 1 то вызываем ворона, а если 0 то вызываем ангела
        if (this.getHealth() > 0 && druidsAbilityWasUsed == 1) {
            if (whoWillCall() == 1) {
                boss.setDamage(boss.getDamage() + (boss.getDamage() / 2));
            } else if (whoWillCall() == 0) {
                for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getAbility() == SuperAbility.HEAL && heroes[i].getHealth()>0) {
                        RPG_Game.medicIsAliveDruid(heroes, boss);
                    }
                }
            }
        }
    }
}

