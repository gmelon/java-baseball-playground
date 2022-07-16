package baseball;

import java.util.Date;
import java.util.Random;

public class Ball {

    private String ballNumber = "";
    private int BALL_NUMBER_COUNT = 3;
    private int RANDOM_INTEGER_UPPER_LIMIT = 10;

    public String getBallNumber() {
        return ballNumber;
    }

    public Ball() {
        generateRandomBallNumber();
    }

    private void generateRandomBallNumber() {
        for (int i = 0; i < BALL_NUMBER_COUNT; i++) {
            ballNumber += addToBallNumberIfItIsANewNumber();
        }
    }

    private String addToBallNumberIfItIsANewNumber() {
        int newNumber = generateRandomInteger(new Date().getTime());
        if (ballNumber.contains(String.valueOf(newNumber))) {
            // 중복 숫자가 생성되면 다시 한 번 시도
            return addToBallNumberIfItIsANewNumber();
        }
        return String.valueOf(newNumber);
    }

    private int generateRandomInteger(long seed) {
        Random rand = new Random(seed);
        return rand.nextInt(RANDOM_INTEGER_UPPER_LIMIT);
    }

}
