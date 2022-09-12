package baseball;

import baseball.utils.InputView;

public class InputViewTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int number = InputView.nextInt();
            System.out.println(number);
        }
    }

}
