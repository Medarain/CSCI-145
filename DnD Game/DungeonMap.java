import java.util.Scanner;

public class DungeonMap {
    private Room[][] rooms;
    private Player player;
    private int playerRow;
    private int playerColumn;

    public DungeonMap(int rows, int columns, Player player, Scanner scanner) {
        this.rooms = new Room[rows][columns];
        this.player = player;
        this.playerRow = 0;
        this.playerColumn = 0;

        // initialise rooms with the scanner
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rooms[i][j] = new Room(scanner);
            }
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void print() {
        // prints the top border of the map
        System.out.print("+");
        for (int j = 0; j < rooms[0].length; j++) {
            System.out.print("---+");
        }
        System.out.println();

        for (int i = 0; i < rooms.length; i++) {
            System.out.print("|");
            for (int j = 0; j < rooms[0].length; j++) {
                if (i == playerRow && j == playerColumn) {
                    // print the player's position
                    System.out.print(" " + player.getPlayerClass().charAt(0) + " |");
                } else if (rooms[i][j].hasVisited()) {
                    // print '*' for visited rooms
                    System.out.print(" * |");
                } else {
                    // print ' ' for unvisited rooms
                    System.out.print("   |");
                }
            }
            System.out.println();

            // prints the bottom border of the row
            System.out.print("+");
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print("---+");
            }
            System.out.println();
        }
    }

    public void movePlayer(char direction) {
        int newRow = playerRow;
        int newColumn = playerColumn;

        switch (direction) {
            case 'W': newRow--; 
            break;
            case 'S': newRow++; 
            break;
            case 'D': newColumn++; 
            break;
            case 'A': newColumn--; 
            break;
            default: System.out.println("Invalid move!"); 
            return;
        }

        //checks if in bounds of map
        if (newRow >= 0 && newRow < rooms.length && newColumn >= 0 && newColumn < rooms[0].length) {
            //updates position to map
            playerRow = newRow;
            playerColumn = newColumn;

            if(rooms[playerRow][playerColumn].hasVisited()){
                System.out.println("You feel like you've been here before...");
            }else{
                //triggers the enter from room
                rooms[playerRow][playerColumn].enter(player);  
            }
        }else {
            System.out.println("You cannot move through walls!");
        }
    }
}
