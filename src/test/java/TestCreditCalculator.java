import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestCreditCalculator {

    CreditCalculator sut;

    @BeforeEach
    public void init() {
        sut = new CreditCalculator();
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testMonthlyPaymentCalculation(int creditAmount, int creditDuration, double rate, int expected) {
        int actual = sut.monthlyPaymentCalculation(creditAmount, creditDuration, rate);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("source1")
    public void testTotalRefund(int creditAmount, int creditDuration, int expected) {
        int actual = sut.totalRefund(creditAmount, creditDuration);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("source2")
    public void testOverpaymentCalculation (int creditAmount, int totalRefund, int expected) {
        int actual = sut.overpaymentCalculation(creditAmount, totalRefund);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(1_500_000, 60, 9.9, 31_796)
        );
    }

    private static Stream<Arguments> source1() {
        return Stream.of(
                Arguments.of(1_500_000, 60, 1_907_808)
        );
    }

    private static Stream<Arguments> source2() {
        return Stream.of(
                Arguments.of(1_500_000, 1_907_808, 407_808)
        );
    }
}
