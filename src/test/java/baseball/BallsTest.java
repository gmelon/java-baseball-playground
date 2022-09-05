package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.status.PlayStatus;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallsTest {

    Balls com;

    @BeforeEach
    void setUp() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void 낫싱() {
        Balls user = new Balls(Arrays.asList(4, 5, 6));
        PlayStatus playStatus = com.play(user);
        assertThat(playStatus.getStrike()).isEqualTo(0);
        assertThat(playStatus.getBall()).isEqualTo(0);
        assertThat(playStatus.isGameEnd()).isFalse();
    }

    @Test
    void _3볼() {
        Balls user = new Balls(Arrays.asList(2, 3, 1));
        PlayStatus playStatus = com.play(user);
        assertThat(playStatus.getStrike()).isEqualTo(0);
        assertThat(playStatus.getBall()).isEqualTo(3);
        assertThat(playStatus.isGameEnd()).isFalse();
    }

    @Test
    void _2볼_1스트라이크() {
        Balls user = new Balls(Arrays.asList(2, 1, 3));
        PlayStatus playStatus = com.play(user);
        assertThat(playStatus.getStrike()).isEqualTo(1);
        assertThat(playStatus.getBall()).isEqualTo(2);
        assertThat(playStatus.isGameEnd()).isFalse();
    }

    @Test
    void _3스트라이크() {
        Balls user = new Balls(Arrays.asList(1, 2, 3));
        PlayStatus playStatus = com.play(user);
        assertThat(playStatus.getStrike()).isEqualTo(3);
        assertThat(playStatus.getBall()).isEqualTo(0);
        assertThat(playStatus.isGameEnd()).isTrue();
    }
}