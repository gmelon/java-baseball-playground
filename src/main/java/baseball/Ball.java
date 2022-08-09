package baseball;

import java.util.Date;
import java.util.Random;

public class Ball {

    private String ballNumber = "";
    private int BALL_NUMBER_COUNT = 3;
    private int RANDOM_INTEGER_UPPER_LIMIT = 10;

    public Ball() {
        generateRandomBallNumber();
    }

    public String getBallNumber() {
        return ballNumber;
    }

    private void generateRandomBallNumber() {
        for (int i = 0; i < BALL_NUMBER_COUNT; i++) {
            ballNumber += getNewBallNumberIfItIsNotRepeated();
        }
    }

    private String getNewBallNumberIfItIsNotRepeated() {
        int newNumber = generateRandomInteger(new Date().getTime());
        if (ballNumber.contains(String.valueOf(newNumber))) {
            // 중복 숫자가 생성되면 다시 한 번 시도
            return getNewBallNumberIfItIsNotRepeated();
        }
        return String.valueOf(newNumber);
    }

    private int generateRandomInteger(long seed) {
        Random rand = new Random(seed);
        return rand.nextInt(RANDOM_INTEGER_UPPER_LIMIT);
    }

    public boolean determineVictory(String givenBallNumber) {
        return givenBallNumber.equals(getBallNumber());
    }

    public String checkReasonOfDefeat(String givenBallNumber) {
        char[] charBallArray = givenBallNumber.toCharArray();

        // ball count
        int ballCount = 0;
        for (int i = 0; i < charBallArray.length; i++) {
            ballCount += checkBallCount(charBallArray[i], i);
        }

        // strike count
        int strikeCount = 0;
        for (int i = 0; i < charBallArray.length; i++) {
            strikeCount += checkStrikeCount(charBallArray[i], i);
        }

        return makeDefeatMessage(ballCount, strikeCount);
    }

    private String makeDefeatMessage(int ballCount, int strikeCount) {
        // make result String
        String result = "";
        if (ballCount != 0) {
            result += ballCount + "볼 ";
        }
        if (strikeCount != 0) {
            result += strikeCount + "스트라이크";
        }
        if (result.length() == 0) {
            result = "포볼";
        }
        return result.trim();
    }

    private int checkBallCount(char c, int i) {
        if (checkStrikeCount(c, i) == 1) {
            // strike 인 경우
            return 0;
        }
        if (getBallNumber().contains(String.valueOf(c))) {
            // ball의 숫자가 모두 다르므로 strike가 아니면서 해당 숫자를 포함하고 있다면 볼이다
            return 1;
        }
        return 0;
    }

    private int checkStrikeCount(char c, int i) {
        if (getBallNumber().charAt(i) == c) {
            return 1;
        }
        return 0;
    }

}
