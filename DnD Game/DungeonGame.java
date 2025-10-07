import java.util.Scanner;

public class DungeonGame {
    /* Reference to the DungeonMap the Player is in */
    private DungeonMap map;
    /* Reference to the Player in the dungeon */
    private Player player;
    private Scanner scanner;

    /* Initialises the size of the dungeon */
	public DungeonGame(int rows, int columns) {
		this.scanner = new Scanner(System.in);
        this.map = new DungeonMap(rows, columns, player,scanner);
        initialisePlayer();
	}

    /*Initialises player character */
	private void initialisePlayer(){
        System.out.println("Choose a class: (1) Warrior (2) Thief (3) Mage");
        int choice = scanner.nextInt();
        if (choice == 1){
            player = new Player("Warrior", 100, 15, 1.0);
        }else if(choice == 2){
            player = new Player("Thief", 70, 10, 1.2);
        }else if(choice == 3){
            player = new Player("Mage", 40, 20, 1.0);
        }
        map.setPlayer(player);
    }

	/* Main loop of the game, which handles
	non-combat related user input. Continues
	until the Player either wins or loses. */
    public void play() {
        System.out.println("You are in a dungeon !!\r\n" + //
                        "There are monsters , bags of gold , and healing elixirs in each room .\r\n" + //
                        "Can you find 100 gold pieces and pay the evil professor to let you out\r\n" + //
                        "before the monsters kill you ?");
        while (player.getHealth() > 0 && player.getGold() < 100) {
            map.print();
            System.out.println("Gold: " + player.getGold() + ", Health: " + player.getHealth());
            System.out.println("Move: (W) Up, (A) Left, (S) Down, (D) Right");
            char move = scanner.next().toUpperCase().charAt(0);
            map.movePlayer(move);
        }

        if (player.getGold() >= 100) {
            System.out.println("You've escaped! Well done!!");
        }else{
            System.out.println("You Died."); //dark souls type shit
        }
    }
}
