package kg.geektech.game.players;

import java.util.Random;

public class Avrora extends Hero {
    public Avrora(int health, int damage, Names name) {
        super(health, damage, SuperAbility.INVISIBLE, name);
    }
    private static int avrorasAbilityWasUsed;
    private static int avrorasExtraDamage;

    private static void avrorasAbility(){
        if (avroraWillHit()==1){
            avrorasAbilityWasUsed++ ;
        }
    }
    private static int avroraWillHit() {
        Random hit = new Random();
        boolean hitAvrora = hit.nextBoolean();
        if (hitAvrora) {
            return 1;
        } else return 0;
    }
    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        avrorasAbility();
            if (this.getHealth() > 0 && avrorasAbilityWasUsed <= 2 && avrorasAbilityWasUsed !=0){
                this.setHealth(boss.getDamage() + this.getHealth());
                avrorasExtraDamage = avrorasExtraDamage + boss.getDamage();
                avrorasAbilityWasUsed++;
            } else if (avrorasAbilityWasUsed == 3) {
            boss.setHealth(boss.getHealth() - (this.getDamage()+avrorasExtraDamage));
            avrorasAbilityWasUsed++;
            }
    }
}

