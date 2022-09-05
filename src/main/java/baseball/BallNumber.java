package baseball;

public class BallNumber {

    private int ballNo;

    public BallNumber(int ballNo) {
        validateBallNo(ballNo);
        this.ballNo = ballNo;
    }

    private void validateBallNo(int ballNo) {
        if (ballNo < 1 || ballNo > 9) {
            throw new IllegalArgumentException("볼 숫자는 1에서 9사이의 자연수여야 합니다.");
        }
    }

    public int getBallNo() {
        return ballNo;
    }
}