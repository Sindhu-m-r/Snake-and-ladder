package game;

import Board.board;
import Dice.Dice;
import coordinates.Coordinates;
import jumper.Jumper;
import players.players;

public class game {
    board board;
    boolean[] isAllowed;
    players[] players;
    int turn;
    Coordinates[] places;
    Dice dice;

    public game(board board, players[] players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        turn = 0;
        isAllowed = new boolean[players.length];
        places = new Coordinates[players.length];
        for (int i = 0; i < players.length; i++)
            places[i] = new Coordinates(board.getBoardSize() - 1, 0);
    }

    public void play() {
        while (true) {
            int num = dice.diceRoll();
            System.out.println(players[turn].getPlayerName() + "rolled -> " + num + "[" + places[turn].getRow() + ","
                    + places[turn].getcol() + "]");
            if (!isAllowed[turn]) {
                if (num != 1) {
                    turn = 1 - turn;
                    continue;
                } else {
                    isAllowed[turn] = true;
                }
            }

            Coordinates newCoordinates = getNewCoordinates(places[turn], num);
            if (newCoordinates.getRow() < 0) {
                System.out.println(players[turn].getPlayerName() + " has won");
                return;

            }
            places[turn] = newCoordinates;
            turn = 1 - turn;
        }
    }

    private Coordinates getNewCoordinates(Coordinates olCoordinates, int num) {
        int row = olCoordinates.getRow();
        int col = olCoordinates.getcol();

        while (num > 0) {
            if (row % 2 != 0) {
                if (col == board.getBoardSize() - 1)
                    row--;
                else
                    col++;
            } else {
                if (col == 0)
                    row--;
                else
                    col--;
            }
            num--;
        }
        if (row < 0)
            return new Coordinates(row, col);
        if (checkIfJumperExists(row, col)) {
            Jumper jumper = board.jumpers.get(board.board[row][col]);
            return jumper.end;

        }
        return new Coordinates(row, col);

    }

    private boolean checkIfJumperExists(int row, int col) {
        return board.jumpers.containsKey(board.board[row][col]);

    }
}
