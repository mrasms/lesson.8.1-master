package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Medic extends Hero {
    private int healPoints;

    public Medic (int health, int damage, int healPoints, Names name) {
        super(health, damage, SuperAbility.HEAL, name);
        this.healPoints = healPoints;
    }


    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {

        if (RPG_Game.getMedicIsAlive()>=1 && RPG_Game.getMedicIsAlive()<=2){
            int number = RPG_Game.random.nextInt(this.getHealPoints()) + 1;
            this.setHealPoints(this.getHealPoints()+number);
            RPG_Game.setMedicIsAlive(RPG_Game.getMedicIsAlive()+2);
        }
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i] != this) {
                heroes[i].setHealth(heroes[i].getHealth() + this.healPoints);
            }
        }

    }
}
