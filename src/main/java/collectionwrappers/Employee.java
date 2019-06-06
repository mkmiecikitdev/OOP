package collectionwrappers;

import java.math.BigDecimal;

class Employee {

    private static final BigDecimal MANAGER_MIN_EARNINGS = BigDecimal.valueOf(10000);

    private final String pesel;
    private final BigDecimal earnings;

    Employee(final String pesel, final BigDecimal earnings) {
        this.pesel = pesel;
        this.earnings = earnings;
    }

    boolean isManager() {
        return earnings.compareTo(MANAGER_MIN_EARNINGS) >= 0;
    }

    String getPesel() {
        return pesel;
    }

    BigDecimal getEarnings() {
        return earnings;
    }
}
