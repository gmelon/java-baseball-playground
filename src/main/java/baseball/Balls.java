package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    public static final int BALL_COUNT = 3;
    private List<Ball> balls;

    public Balls(List<Integer> intBalls) {
        mapBallNo(intBalls);
    }

    public PlayStatus play(Balls userBalls) {
        PlayStatus playStatus = new PlayStatus();
        for (Ball userBall : userBalls.getBalls()) {
            playStatus.record(getBallStatus(userBall));
        }
        return playStatus;
    }

    private BallStatus getBallStatus(Ball userBall) {
        // comBall 전체에 대해 하나의 userBall로 play() 호출
        return this.balls.stream()
            .map(comBall -> comBall.play(userBall))
            .filter(BallStatus::isNotNothing)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    private void mapBallNo(List<Integer> intBalls) {
        balls = new ArrayList<>();
        for (int i = 0; i < BALL_COUNT; i++) {
            balls.add(new Ball(intBalls.get(i), i + 1));
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
