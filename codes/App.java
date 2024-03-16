import java.util.HashMap;

import Board.board;
import Dice.Dice;
import coordinates.Coordinates;
import game.game;
import jumper.Jumper;
import players.players;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, Jumper> map = new HashMap<>();
        map.put("6", new Jumper(new Coordinates(9, 5), new Coordinates(6, 6)));
        map.put("97", new Jumper(new Coordinates(0, 1), new Coordinates(9, 9)));
        map.put("21", new Jumper(new Coordinates(7, 0), new Coordinates(0, 9)));
        map.put("64", new Jumper(new Coordinates(3, 3), new Coordinates(7, 4)));
        players p1 = new players();
        p1.setPlayerDetailsFromUser(p1);
        players p2 = new players();
        p2.setPlayerDetailsFromUser(p2);

        System.out.println("player name:" + p1.getPlayerName());
        System.out.println("player name:" + p2.getPlayerName());
        board b = new board(10, map);
        b.printBoard();
        

        // Dice dic = new Dice();
        // System.out.println(dic.diceRoll());

        // Coordinates c = new Coordinates(9, 4);
        // System.out.println(c.PrintCoordinater());

        // Jumper j = new Jumper(c, c);
        // System.out.println(j.getJumperName());
        game game = new game(b, new players[] { p1, p2 }, new Dice());
        game.play();

    }
}
