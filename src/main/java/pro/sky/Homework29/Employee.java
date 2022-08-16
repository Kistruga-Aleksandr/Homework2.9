package pro.sky.Homework29;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {

    private final String lastName;
    private final String firstName;
    private final Integer salary;
    private final Integer department;
    private Integer id;


    public Employee(String lastName, String firstName, Integer salary, Integer department) {
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(salary, employee.salary) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, salary, department);
    }

}
