package day21;

public class PlayerSimulation {
    private int score = 0;
    private int position;

    public PlayerSimulation(int position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public int getPosition() {
        return position;
    }

    public void incrementAndCheckPosition(int position) {
        this.position += position;
        while (this.position > 10) {
            this.position -= 10;
        }
    }

    public static void playRound(PlayerSimulation player, Die die){
        for (int i = 1; i <= 3; i++){
            player.incrementAndCheckPosition(die.roll());
        }
        player.incrementScore(player.getPosition());
    }

    private void incrementScore(int increment){
        this.score += increment;
    }
}
