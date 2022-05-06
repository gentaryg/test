import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.ConstructorParameters;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestCalculator {
   Calculator cal;
    @BeforeAll
    public static void beforeAllMethod() {System.out.println("BeforeAll call");}

    @BeforeEach
    public void beforeEachMethod() {
        System.out.println("BeforeEach call");
        cal = Calculator.instance.get();
    }

    @AfterEach
    public void afterEachMethod() {System.out.println("AfterEach call");}

    @AfterAll
    public static void afterAllMethod() {System.out.println("BeforeAll call");}

    @Test
    public void testAddPlus () {
        int a = 2, b = 3, expected = 5;

        int result = cal.plus.apply(a,b);

        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void testMultiply(int a) {
        int b = 0;
        int result = cal.multiply.apply(a, b);
        int expected = 0;

        Assertions.assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("testSource")
    public void testParameterizedSubtract(int a, int b, int expected) {
        int result = cal.minus.apply(a, b);

        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments> testSource() {
        return Stream.of(
                Arguments.of(5, 3, 2),
                Arguments.of(10, 5, 5),
                Arguments.of(250, 50, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("testSource2")
    public void testParameterizeSquare(int a, int expected) {
        int result = cal.pow.apply(a);

        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments> testSource2() {
        return Stream.of(
                Arguments.of(5, 25),
                Arguments.of(10, 100),
                Arguments.of(2, 4)
        );
    }






}
