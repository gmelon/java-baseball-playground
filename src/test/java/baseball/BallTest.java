package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    void generateBallNumbers() {
        Ball ball = new Ball();

        // 3자리 숫자를 생성하는 지 확인
        assertThat(ball.getBallNumber().length()).isEqualTo(3);

        // 각각의 숫자가 모두 다른 지 확인
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                assertThat(ball.getBallNumber().charAt(i)).isNotEqualTo(
                    ball.getBallNumber().charAt(j));
            }
        }
    }

}