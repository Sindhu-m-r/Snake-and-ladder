package Dice;

public class Dice {
    int MIN = 1;
    int MAX = 6;

    public int diceRoll() {
        double d = (Math.random() * (MAX - MIN) + MIN);
        return (int) d;
    }
}
