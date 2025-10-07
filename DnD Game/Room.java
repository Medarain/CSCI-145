import java.util.Random;
import java.util.Scanner;

/* Represents a Room in the Dungeon, where
encounters with Monsters and Loot occur */
public class Room {
    /* Indicates whether or not this Room
    instance has been visited already */
    private boolean visited;

    private Random random;
    private Scanner scanner;

    public Room(Scanner scanner){
        this.visited = false;
        this.random = new Random();
        this.scanner = scanner;
    }

    public Monster makeRandomMonster(){
        int monsterType = random.nextInt(4);
        switch(monsterType){
            case 0: return new Monster(6, 10, "Goblin");
            case 1: return new Monster(12, 15, "Zombie");
            case 2: return new Monster(18, 20, "Orc");
            case 3: return new Monster(55, 5, "Sizemogre");
            default: return new Monster(6, 10, "Goblin");
        }
    }

	/* Handles encounter logic when a Player
	enters this Room. Includes combat resolution
	and obtaining loot. */
    public void combat(Player player, Monster monster){
            while (!monster.deadMonster() && player.getHealth() > 0){
                System.out.println("Monster encountered " + monster.monsterType);
                System.out.println("Monster HP: " + monster.getHealth());
                System.out.println("Your HP: " + player.getHealth());
                System.out.println("Choose to (A)ttack or (R)un");
                char choice = scanner.next().toUpperCase().charAt(0);
                if (choice == 'A'){
                    int monDamage = monster.attack(player);
                    System.out.println("The " + monster.monsterType + " attacks you and you take " + monDamage + " damage!");
                    if (player.getHealth() > 0){
                        int playerDamage = player.attack(monster);
                        System.out.println("You attack the " + monster.monsterType + " and deal " + playerDamage + " damage!");
                    }
            }else if (choice == 'R'){
                int monDamage = monster.attack(player);
                System.out.println(monster.monsterType + " attacks you as you run and you take " + monDamage + " damage!");
                break;
            }else{
                System.out.println("You have to (A)ttack or (R)un!");
            }
        }
        if (monster.deadMonster()){
            System.out.println("The " + monster.monsterType + " has fallen!");
        }
    }

    public void enter(Player player) {
            if (!visited){
                visited = true;
                int encounterType = random.nextInt(4);
                if (encounterType < 3){
                    Monster monster = makeRandomMonster();
                    combat(player, monster);
            }else if(encounterType == 3){
                int gold = random.nextInt(20) + 1;
                player.onLoot(gold);
                System.out.println("You found " + gold);
            }else if(encounterType == 4){
                int heal = random.nextInt(10) + 1;
                player.onHeal(heal);
                System.out.println("You found a healing potion and drank it to heal " + heal + "HP "+ player.getHealth());
            }
        }
        
    }

    /* Accessor for the visited field */
    public boolean hasVisited() {
        return this.visited;
    }
}
