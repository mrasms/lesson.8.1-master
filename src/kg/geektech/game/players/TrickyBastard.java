package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class TrickyBastard extends Hero {
    public TrickyBastard(int health, int damage, Names name) {
        super(health, damage, SuperAbility.PLAY_DEAD, name);
    }

    private static int bastardWillHit() {
        Random hit = new Random();
        boolean hitBastard = hit.nextBoolean();
        if (hitBastard) {
            return 1;
        } else return 0;
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        if (bastardWillHit()==1 && this.getHealth()>0){
            this.setHealth(this.getHealth()+ boss.getDamage());
            boss.setHealth(boss.getHealth()+this.getDamage());
        }
    }
}

