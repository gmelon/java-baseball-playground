package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.service.BallNumber;
import org.junit.jupiter.api.Test;

class BallNumberTest {

    @Test
    void 비정상_입력() {
        assertThrows(IllegalArgumentException.class, () -> new BallNumber(-1));
        assertThrows(IllegalArgumentException.class, () -> new BallNumber(10));
    }

    @Test
    void 정상_입력() {
        assertThat((new BallNumber(1)).getBallNo()).isEqualTo(1);
        assertThat((new BallNumber(9)).getBallNo()).isEqualTo(9);
    }

}