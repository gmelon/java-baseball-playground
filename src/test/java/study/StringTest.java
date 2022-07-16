package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");

        actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";
        actual = actual.substring(actual.indexOf('(') + 1, actual.indexOf(')'));
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드로 문자열에서 특정 위치의 문자를 가져온다. 전체 문자열의 범위를 벗어나면 Exception이 발생한다.")
    void charAt() {
        assertThat("abc".charAt(0)).isEqualTo('a');

        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }
}
