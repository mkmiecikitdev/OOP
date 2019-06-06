package collectionwrappers;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StaffTest {

    private static final Employee e1 = new Employee("pesel1", BigDecimal.valueOf(12000));
    private static final Employee e2 = new Employee("pesel2", BigDecimal.valueOf(15000));
    private static final Employee e3 = new Employee("pesel3", BigDecimal.valueOf(9500));


    private static final List<Employee> STANDARD_STAFF = asList(e1, e2, e3);

    @Test
    public void shouldCreateEmptyStaff() {

        Staff staff = Staff.empty();

        assertThat(staff.size()).isEqualTo(0);

    }

    @Test
    public void shouldRegisterThreePersonAndReturnCorrectStats() {

        Staff staff = Staff.fromList(STANDARD_STAFF);

        assertThat(staff.size()).isEqualTo(3);
        assertThat(staff.managersCount()).isEqualTo(2);
        assertThat(staff.noManagersCount()).isEqualTo(1);
        assertThat(staff.earningsSum()).isEqualTo(BigDecimal.valueOf(36500));
        assertThat(staff.managerEarningsSum()).isEqualTo(BigDecimal.valueOf(27000));

    }

    @Test
    public void shouldRemovePersons() {

        Staff staff = Staff.fromList(STANDARD_STAFF);

        staff.removeEmployee("pesel1");
        staff.removeEmployee(e2);

        assertThat(staff.size()).isEqualTo(1);
        assertThat(staff.managersCount()).isEqualTo(0);
        assertThat(staff.managerEarningsSum()).isEqualTo(BigDecimal.ZERO);

    }

    @Test
    public void shouldThrowExceptionWhenRegisterWithExistingPesel() {

        Staff staff = Staff.fromList(STANDARD_STAFF);

        assertThatThrownBy(() -> staff.registerEmployee(new Employee("pesel1", BigDecimal.valueOf(500))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You cannot register person with existing pesel");

    }

    @Test
    public void shouldThrowExceptionWhenRegisterToMuchEmployee() {

        Staff staff = Staff.fromList(STANDARD_STAFF);
        staff.registerEmployee(new Employee("pesel4", BigDecimal.TEN));

        assertThatThrownBy(() -> staff.registerEmployee(new Employee("pesel5", BigDecimal.valueOf(500))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You cannot register more employees");

    }


}
