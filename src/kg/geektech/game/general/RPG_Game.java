package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();
    private static int MedicIsAlive;

    public static int getMedicIsAlive() {
        return MedicIsAlive;
    }

    public static void setMedicIsAlive(int medicIsAlive) {
        MedicIsAlive = medicIsAlive;
    }

    private static int aliveHeroes;

    public static int getAliveHeroes() {
        return aliveHeroes;
    }

    public static void setAliveHeroes(int aliveHeroes) {
        RPG_Game.aliveHeroes = aliveHeroes;
    }


    public static void start() {
        Boss boss = new Boss(7000, 50);

        Warrior warrior = new Warrior(270, 15, Names.WARRIOR);
        Medic doctor = new Medic(220, 5, 15, Names.DOCTOR);
        Magic magic = new Magic(240, 20, Names.MAGE);
        Berserk berserk = new Berserk(300, 20, Names.BERSERK);
        Medic intern = new Medic(250, 10, 5, Names.INTERN);
        Thor thor = new Thor(300, 15, Names.THOR);
        Golem golem = new Golem(400, 10, Names.GOLEM);
        Witcher witcher = new Witcher(220,0, Names.WITCHER);
        Avrora avrora = new Avrora(300, 20, Names.AVRORA);
        Druid druid = new Druid(250, 20,Names.DRUID);
        Hacker hacker = new Hacker(250,15,Names.HACKER);
        TrickyBastard bastard= new TrickyBastard(200, 20, Names.TRICKY_BASTARD);
        Hero[] heroes = {warrior, doctor, magic, berserk, golem, intern, thor, witcher, avrora, druid, hacker, bastard};


        printStatistics(heroes, boss);
        while (!isGameFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        round_number++;
        aliveHeroes(heroes, boss);
        bossHits(heroes, boss);
        heroesHit(heroes, boss);
        applySuperPowers(heroes, boss);
        printStatistics(heroes, boss);

    }



    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("ROUND " + round_number);
        System.out.println("Alive heroes: " + aliveHeroes);
        System.out.println("Boss health: " + boss.getHealth()
                + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName()
                    + " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
    }

    private static void bossHits(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                }

            }
        }



    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void applySuperPowers(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(heroes, boss);
            }
        }
    }


    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
    public static void aliveHeroes(Hero[] heroes, Boss boss) {
        setAliveHeroes(0);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getHealth() != 0) {
                setAliveHeroes(getAliveHeroes() + 1);
            }
        }
    }
    public static void medicIsAliveDruid(Hero[] heroes, Boss boss) {
        setMedicIsAlive(0);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && heroes[i].getHealth() != 0 && heroes[i].getAbility()==SuperAbility.HEAL) {
                setMedicIsAlive(getMedicIsAlive() + 1);
            }
        }
    }


}
