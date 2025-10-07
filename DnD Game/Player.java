
public class Player {
	/* Current health of this Player */
    private int health;
    /* Current gold of this Player */
    private int gold;
    /* Damage this Player inflicts */
    private int damage;
    /* Class of this Player */
    private String playerClass;
    /* Modifier to loot obtained by this Player */
    private double lootModifier;


    public Player(String playerClass, int health, int damage, double lootModifier){
        this.playerClass = playerClass;
        this.health = health;
        this.damage = damage;
        this.lootModifier = lootModifier;
        this.gold = 0;
    }

    public String getPlayerClass(){
        return playerClass;
    }

    public int getHealth(){
        return health;
    }
    
    public int getGold(){
        return gold;
    }

    /* Hits the targeted Monster */
    public int attack(Monster target) {
        target.onHit(damage);
        return(damage);
    }

	/* Removes health from this Player
    when hit by a Monster */
    public void onHit(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

	/* Adds health to this Player when healed */
    public void onHeal(int health) {
        this.health += health;
    }

	/* Adds gold to this Player when obtained */
    public void onLoot(int gold) {
        this.gold += (int) (gold * lootModifier);
    }
}
