package collectionwrappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Staff {

    private static final int MAX_STAFF_SIZE = 10;

    private final Map<String, Employee> staff;

    private Staff(final Map<String, Employee> staff) {
        this.staff = staff;
    }

    static Staff empty() {
        return new Staff(new HashMap<>());
    }

    static Staff fromList(List<Employee> list) {
        final Map<String, Employee> staff = list.stream()
                .collect(toMap(Employee::getPesel, employee -> employee));

        return new Staff(staff);
    }

    int size() {
        return staff.size();
    }

    void registerEmployee(final Employee employee) {
        if(staff.size() >= MAX_STAFF_SIZE)
            throw new IllegalArgumentException("You cannot register more employees");

        if(staff.keySet().contains(employee.getPesel())) {
            throw new IllegalArgumentException("You cannot register person with existing pesel");
        }

        staff.put(employee.getPesel(), employee);
    }

    void removeEmployee(final Employee employee) {
        removeEmployee(employee.getPesel());
    }

    void removeEmployee(final String pesel) {
        staff.remove(pesel);
    }

}
