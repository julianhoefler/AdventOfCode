package day21;

import static day21.PlayerSimulation.playRound;

public class GameSimulation {

    public static void playGame(PlayerSimulation player1,
                                PlayerSimulation player2,
                                Die die,
                                int winningScore) {

        while (player1.getScore() < winningScore && player2.getScore() < winningScore) {
            playRound(player1, die);
            if (player1.getScore() < winningScore) {
                playRound(player2, die);
            }
        }
    }
}

