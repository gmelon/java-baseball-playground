package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void main() {
        String input = "2 + 3 * 4 / 2";
        // stdin, stdout을 test 하기 위해 System의 in/out을 변경..
        // todo, test가 어려운 프로덕션 코드, 얘들을 main에서 어떻게 분리해내지?
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Application.main(new String[]{});
        assertThat(out.toString()).isEqualTo(10);
    }
}