import src.Game;
import src.Parameters;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        
        game.addPlayers();
        Parameters.configure();
        game.play();
    }
}