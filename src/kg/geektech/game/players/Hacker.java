package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero {
    public Hacker(int health, int damage, Names name) {
        super(health, damage, SuperAbility.PICK_UP_AND_GIVE_AVAY, name);
    }
private static int ability;


    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int number = RPG_Game.random.nextInt(boss.getDamage()+1);
        if (ability==0){
            ability++;
        }
        else if (ability==1 && this.getHealth() > 0&& boss.getHealth() >= boss.getDamage()+1){
            boss.setHealth(boss.getHealth()-number);
            for (int i = 0; i < heroes.length; i++) {
                int whoIsLucky = RPG_Game.random.nextInt(RPG_Game.getAliveHeroes()-1);
                if (heroes[whoIsLucky].getHealth()>0){
                heroes[whoIsLucky].setHealth(heroes[i].getHealth()+number);
                ability--;
                    break;
                }else if (heroes[whoIsLucky].getHealth()==0) {
                    continue;
                }
            }
        }

    }
}

