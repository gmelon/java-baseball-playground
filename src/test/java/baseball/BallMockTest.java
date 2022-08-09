package baseball;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

public class BallMockTest {

    Ball ball;

    @BeforeEach
    void setUp() {
        ball = Mockito.spy(new Ball());
    }

    @Test
    void determineVictory() {
        Mockito.doReturn("365").when(ball).getBallNumber();
        assertThat(ball.determineVictory("365")).isTrue();
        assertThat(ball.determineVictory("980")).isFalse();
    }

    @Test
    void checkReasonOfDefeat() {
        Mockito.doReturn("019").when(ball).getBallNumber();
        assertThat(ball.checkReasonOfDefeat("013")).isEqualTo("2스트라이크");
        assertThat(ball.checkReasonOfDefeat("901")).isEqualTo("3볼");
        assertThat(ball.checkReasonOfDefeat("091")).isEqualTo("2볼 1스트라이크");
        // 아래는 실제로는 실행되지 않는 경우 (determinVictory() false일 경우만 실행)
        assertThat(ball.checkReasonOfDefeat("019")).isEqualTo("3스트라이크");
    }

}
