package collectionwrappers;

import java.math.BigDecimal;

public class Employee {

    private static final BigDecimal MANAGER_MIN_EARNINGS = BigDecimal.valueOf(10000);

    private final String pesel;
    private final BigDecimal earnings;

    public Employee(final String pesel, final BigDecimal earnings) {
        this.pesel = pesel;
        this.earnings = earnings;
    }

    boolean isManager() {
        return earnings.compareTo(MANAGER_MIN_EARNINGS) >= 0;
    }

    public String getPesel() {
        return pesel;
    }
}
