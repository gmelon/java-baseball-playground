package baseball;

public class BallApplication {

    public static void main(String[] args) {
        boolean optContinueGame;
        do {
            BallGameController ballGameController = new BallGameController();
            optContinueGame = ballGameController.guessAnswer();
        } while (optContinueGame);
    }

}
