import java.util.Random;
enum VARIANTS {
    ROCK,
    PAPER,
    SCISSORS
}
class Player {
    private VARIANTS choice;
    private String name;

    public Player() {
        Random random = new Random();
        this.choice = VARIANTS.values()[random.nextInt(VARIANTS.values().length)];
        this.name = "Bot";
    }

    public Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    public String whoWins(Player player,Player opponent) {
        if (this.choice == opponent.choice) {
            return "Ничья";
        } else if (this.choice == VARIANTS.ROCK && opponent.choice == VARIANTS.SCISSORS)
            return player.name + " победил!";
        else if (this.choice == VARIANTS.PAPER && opponent.choice == VARIANTS.ROCK)
            return player.name + " победил!";
        else if (this.choice == VARIANTS.SCISSORS && opponent.choice == VARIANTS.PAPER)
            return player.name + " победил!";
        else return opponent.name + " победил!";

    }
}