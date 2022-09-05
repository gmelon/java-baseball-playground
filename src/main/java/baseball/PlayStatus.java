package baseball;

public class PlayStatus {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void record(BallStatus status) {
        if (BallStatus.isStrike(status)) {
            strike++;
        }
        if (BallStatus.isBall(status)) {
            ball++;
        }
    }

    public boolean isGameEnd() {
        return strike == 3;
    }
}
