import com.dziakob.Calculator;
import com.dziakob.MyUtil;
import com.dziakob.VariableSource;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyFirstJUnitJupiterTests {
    private final Calculator calculator = new Calculator();

    public static Stream<Arguments> arguments = Stream.of(
            Arguments.of(null,true),
            Arguments.of("",true),
            Arguments.of(" ",true),
            Arguments.of("not blank",false)
    );

    @Test
    void addition() {
        assertEquals(2, calculator.add(1,1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(MyUtil.isOdd(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {""," "})
    @EmptySource
    @NullSource
    void isBlankTestable(String str) {
        assertTrue(MyUtil.isBlank(str));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    void toUppercaseCheck(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(actualValue,expected);
    }

    // EXAMPLE with custom annotation

    @ParameterizedTest
    @VariableSource("arguments")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsVariableSource( String input, boolean expected) {
        assertEquals(expected, Strings.isBlank(input));
    }

}
