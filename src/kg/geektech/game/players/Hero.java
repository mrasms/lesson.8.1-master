package kg.geektech.game.players;

public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private SuperAbility ability;
    private Names name;


    public Hero(int health, int damage, SuperAbility ability, Names name) {
        super(health, damage);
        this.ability = ability;
        this.name = name;
    }

    public Names getName() {
        return name;
    }

    public void setName(Names name) {
        this.name = name;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void setAbility(SuperAbility ability) {
        this.ability = ability;
    }
}
