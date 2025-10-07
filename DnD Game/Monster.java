import java.util.Random;

public class Monster {
	/* Current health of this Monster */
    private int health;
    /* Max damage this Monster inflicts */
    private int maxDamage;
    /* Type of this Monster */
    public String monsterType;
    /* Property to deal random damage */
    private Random random;

    public Monster(int health, int maxDamage, String monsterType){
        this.health = health;
        this.maxDamage = maxDamage;
        this.monsterType = monsterType;
        this.random = new Random();
    }

    public int getHealth(){
        return health;
    }

    /* Hits the targeted Player */
    public int attack(Player target) {
        int damage = random.nextInt(maxDamage) + 1;
        target.onHit(damage);
        return(damage);
    }

    /* Removes health from this Monster
    when hit by a Player */
    public void onHit(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean deadMonster(){
        return health <= 0;
    }
}
