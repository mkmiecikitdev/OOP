package valueobjects;

import org.junit.Test;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AgeTest {

    private static final LocalDate FIXED_NOW_DATE = LocalDate.of(2019,6,6);
    private static final Clock FIXED_CLOCK = Clock.fixed(instant(), ZoneId.systemDefault());

    @Test
    public void shouldCreateAdultAgeFromBirthday() {

        final Age age = Age.fromBirthday(LocalDate.of(2001, 5, 18));

        assertThat(age.getAgeInDate(now())).isEqualTo(18);
        assertThat(age.isAdult(now())).isTrue();

    }

    @Test
    public void shouldCreateNoAdultAgeFromBirthday() {

        final Age age = Age.fromBirthday(LocalDate.of(2002, 5, 18));

        assertThat(age.getAgeInDate(now())).isEqualTo(17);
        assertThat(age.isAdult(now())).isFalse();

    }


    private LocalDate now() {
        return LocalDate.now(FIXED_CLOCK);
    }

    private static Instant instant() {
        return FIXED_NOW_DATE
                .atStartOfDay()
                .toInstant(ZoneOffset.UTC);
    }

}
