package valueobjects;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Money {

    private static final Money ZERO = Money.of(0);

    private final BigDecimal value;

    private Money(BigDecimal value) {
        this.value = value;
    }

    static Money of(BigDecimal money) {
        if(money.compareTo(BigDecimal.ZERO ) < 0)
            throw new IllegalArgumentException("Money must be positive");

        return new Money(money);
    }

    static Money of(int money) {
        return of(new BigDecimal(money));
    }

    static Money of(BigInteger money) {
        return of(new BigDecimal(money));
    }

    static Money of(String money) {
        return of(new BigDecimal(money));
    }

    static Money zero() {
        return ZERO;
    }

    Money add(final Money toAdd) {
        return new Money(value.add(toAdd.value));
    }

    Money minus(final Money toAdd) {
        final BigDecimal result = value.subtract(toAdd.value);

        if(result.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Money must be positive");

        return new Money(result);
    }

    Money multiplyBy(int multiplier) {
        if(multiplier < 0)
            throw new IllegalArgumentException("Multiplier must be positive");

        return new Money(value.multiply(new BigDecimal(multiplier)));
    }

    public BigDecimal getValue() {
        return value;
    }
}
