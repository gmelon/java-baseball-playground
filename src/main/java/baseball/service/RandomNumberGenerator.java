package baseball.service;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int MAX_NUMBER = 9;

    public static int getRandomNumber() {
        Random random = new Random(System.currentTimeMillis());
        return (random.nextInt(MAX_NUMBER) + 1);
    }

}
