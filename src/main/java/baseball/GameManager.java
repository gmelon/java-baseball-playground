package baseball;

import baseball.service.Balls;
import baseball.service.RandomNumberGenerator;
import baseball.status.PlayStatus;
import baseball.utils.InputView;
import baseball.utils.OutputView;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public static final int BALL_COUNT = 3;

    public static void main(String[] args) {
        boolean replay = false;
        do {
            Balls comBalls = generateComBalls();

            gamePlay(comBalls);

            replay = askDoMoreGame(replay);
        } while (replay);
    }

    private static boolean askDoMoreGame(boolean replay) {
        OutputView.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (InputView.nextInt() == 1) {
            replay = true;
        }
        return replay;
    }

    private static void gamePlay(Balls comBalls) {
        PlayStatus playStatus;
        do {
            OutputView.print("숫자를 입력해 주세요 : ");

            Balls userBalls = getUserBalls();

            playStatus = comBalls.play(userBalls);

            printGameStatus(playStatus);

        } while (!playStatus.isGameEnd());
    }

    private static Balls getUserBalls() {
        List<Integer> userBalls = new ArrayList<>();
        int userInput = InputView.nextInt();
        for (int i = 0; i < BALL_COUNT; i++) {
            userBalls.add(0, userInput % 10);
            userInput /= 10;
        }
        return new Balls(userBalls);
    }

    private static void printGameStatus(PlayStatus playStatus) {
        if (playStatus.getBall() != 0) {
            OutputView.print(playStatus.getBall() + "볼 ");
        }
        if (playStatus.getStrike() != 0) {
            OutputView.println(playStatus.getStrike() + "스트라이크");
        }
        if (playStatus.getStrike() == 0) {
            OutputView.println();
        }
        if (playStatus.isGameEnd()) {
            OutputView.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static Balls generateComBalls() {
        List<Integer> comBalls = new ArrayList<>();

        while(comBalls.size() < BALL_COUNT) {
            int randomNumber = RandomNumberGenerator.getRandomNumber();
            checkListAndAddNewNumberToList(comBalls, randomNumber);
        }
        System.out.println("comBalls = " + comBalls); // for debug
        return new Balls(comBalls);
    }

    private static void checkListAndAddNewNumberToList(List<Integer> comBalls, int randomNumber) {
        if (!comBalls.contains(randomNumber)) {
            comBalls.add(randomNumber);
        }
    }

}
