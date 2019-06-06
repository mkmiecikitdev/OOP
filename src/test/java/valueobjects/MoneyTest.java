package valueobjects;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void shouldCreateMoneyInDifferentWays() {

        final Money zero = Money.zero();

        assertThat(zero.getValue()).isEqualTo(BigDecimal.ZERO);

        final Money m1 = Money.of(BigInteger.TEN);
        final Money m2 = Money.of(10);
        final Money m3 = Money.of("10");
        final Money m4 = Money.of(BigInteger.TEN);

        assertThat(m1.getValue()).isEqualTo(BigDecimal.TEN);
        assertThat(m2.getValue()).isEqualTo(BigDecimal.TEN);
        assertThat(m3.getValue()).isEqualTo(BigDecimal.TEN);
        assertThat(m4.getValue()).isEqualTo(BigDecimal.TEN);

    }

    @Test
    public void shouldExecuteOperationOnMoneys() {

        final Money money20 = Money.of(20);
        final Money money5 = Money.of(5);
        final int multiplier = 3;

        final Money sum = money5.add(money20);
        final Money subtraction = money20.minus(money5);
        final Money multiplication = money20.multiplyBy(multiplier);

        assertThat(sum.getValue()).isEqualTo(new BigDecimal(25));
        assertThat(subtraction.getValue()).isEqualTo(new BigDecimal(15));
        assertThat(multiplication.getValue()).isEqualTo(new BigDecimal(60));

    }

}
