package baseball.status;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public static boolean isNotNothing(BallStatus status) {
        return status != NOTHING;
    }

    public static boolean isStrike(BallStatus status) {
        return status == STRIKE;
    }

    public static boolean isBall(BallStatus status) {
        return status == BALL;
    }
}
