package baseball;

public class BallGameController {

    Ball ball;

    public BallGameController() {
        this.ball = new Ball();
    }

    public boolean guessAnswer() {
        ResultView.showResult("숫자를 입력해 주세요 : ");
        String input = InputView.getInput();
        if (ball.determineVictory(input)) {
            // 정답
            return askGameContinue();
        }
        // 오답
        ResultView.showResultNewLine(ball.checkReasonOfDefeat(input));
        return guessAnswer();
    }

    private boolean askGameContinue() {
        ResultView.showResultNewLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        ResultView.showResultNewLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = InputView.getInput();
        return input.equals("1");
    }
}
