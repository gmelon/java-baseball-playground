package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.Ball;
import baseball.status.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTest {

    Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(4, 1);
    }

    @Test
    void 스트라이크() {
        Ball user = new Ball(4, 1);
        BallStatus status = com.play(user);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼() {
        Ball user = new Ball(4, 2);
        BallStatus status = com.play(user);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 낫싱() {
        Ball user = new Ball(2, 1);
        BallStatus status = com.play(user);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}