package kg.geektech.game.players;

import java.util.Random;

public class Witcher extends Hero {
    public Witcher(int health, int damage, Names name) {
        super(health, damage, SuperAbility.RESURRECT, name);
    }
    int damage = this.damage;

    private static int witcherWillHit() {
        Random hit = new Random();
        boolean hitWitcher = hit.nextBoolean();
        if (hitWitcher) {
            return 1;
        } else return 0;
    }
    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
            if (this.getHealth() > 0 && (witcherWillHit() == 1)){
                for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getHealth() <= 0 && this.getHealth() > 0 && heroes[i]!=this){
                        heroes[i].setHealth(this.getHealth());
                        this.setHealth(0);
                        break;
                    }
                }
            }
        }
    }

