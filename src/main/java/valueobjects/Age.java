package valueobjects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


class Age {

    private final LocalDate birthday;

    private Age(LocalDate birthday) {
        this.birthday = birthday;
    }

    static Age fromBirthday(final LocalDate birth) {
        return new Age(birth);
    }

    int getAgeInDate(final LocalDate date) {

        if(birthday.isAfter(date)) {
            throw new IllegalArgumentException("Future date cannot be before birthday");
        }

        return getYearsBetween(birthday, date);

    }

    boolean isAdult(final LocalDate now) {
        return getAgeInDate(now) >= 18;
    }

    private static int getYearsBetween(LocalDate date1, LocalDate date2) {
        return (int) ChronoUnit.YEARS.between(date1, date2);
    }


}
