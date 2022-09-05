package baseball;

import java.util.Objects;

public class Ball {

    private BallNumber ballNumber;
    private int ballPos;

    public Ball(int ballNumber, int ballPos) {
        this.ballNumber = new BallNumber(ballNumber);
        this.ballPos = ballPos;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        // TODO ball null check
        if (ball.checkBallNumberEqual(this.ballNumber)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean checkBallNumberEqual(BallNumber ballNumber) {
        return Objects.equals(this.ballNumber, ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return ballPos == ball.ballPos && Objects.equals(ballNumber, ball.ballNumber);
    }

}
