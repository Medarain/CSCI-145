
public class Main {
	/* Entry point of the application */
    public static void main(String[] args) {
        //default map sizing
        int rows = 10;
        int columns = 10;

        if (args.length == 2){
            rows = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
        }

        //Start the game
        DungeonGame game = new DungeonGame(rows, columns);
        game.play();
    }
}