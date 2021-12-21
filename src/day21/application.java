package day21;

public class application {

    public static void exampleMain(String[] args) {

        Die die = new DeterministicDie();

        PlayerSimulation player1 = new PlayerSimulation(10);
        PlayerSimulation player2 = new PlayerSimulation(2);

        GameSimulation.playGame(player1, player2, die, 1000);

        System.out.println("Player 1 Score: " + player1.getScore());
        System.out.println("Player 2 Score: " + player2.getScore());
        System.out.println("Die Rolls: " + die.getRolls());
        System.out.println("Result if Player 1 wins: " + die.getRolls() * player2.getScore());
        System.out.println("Result if Player 2 wins: " + die.getRolls() * player1.getScore());
    }
}