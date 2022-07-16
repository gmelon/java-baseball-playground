package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void plus() {
        assertThat(Operator.plus(5, 5)).isEqualTo(10);
    }

    @Test
    void minus() {
        assertThat(Operator.minus(0, 10)).isEqualTo(-10);
    }

    @Test
    void multiply() {
        assertThat(Operator.multiply(5, 5)).isEqualTo(25);
    }

    @Test
    void divideByNonZero() {
        assertThat(Operator.divide(5, 5)).isEqualTo(1);
    }

    @Test
    void divideByZero() {
        assertThatThrownBy(() -> Operator.divide(5, 0))
            .isInstanceOf(ArithmeticException.class);
    }
}