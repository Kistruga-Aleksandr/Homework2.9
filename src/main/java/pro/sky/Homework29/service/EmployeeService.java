package pro.sky.Homework29.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework29.Employee;
import pro.sky.Homework29.WorkingExceptions.EmployeeAlreadyAddedException;
import pro.sky.Homework29.WorkingExceptions.EmployeeNotFoundException;
import pro.sky.Homework29.WorkingExceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public static final int limitEmployees = 20;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иванов", "Иван", 300000, 5),
            new Employee("Петров", "Роман", 105000, 2),
            new Employee("Сидоров", "Юрий", 150000, 5),
            new Employee("Куликов", "Михайл", 800000, 1),
            new Employee("Ильин", "Александр", 200000, 1),
            new Employee("Рогонов", "Александр", 350000, 3),
            new Employee("Белов", "Евгений", 80000, 4),
            new Employee("Сосновцев", "Виктор", 120000, 4),
            new Employee("Смирнов", "Андрей", 180000, 3),
            new Employee("Андреев", "Роман", 250000, 2)
    ));

    public List<Employee> removeEmployee(String lastName, String firstName, Integer salary, Integer department) {
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employees;

    }

    public List<Employee> getEmployee(String lastName, String firstName, Integer salary, Integer department) {
        Employee employee = new Employee(lastName, firstName, salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employees;
    }

    public List<Employee> getEmployeesByiDepartmentID(Integer departmentId) {
        return employees.stream()
                .filter(employee -> departmentId.equals(employee.getDepartment()))
                .collect(Collectors.toList());
    }


    public Employee searchMinSalary(Integer departmentId) {
        return employees.stream().filter(employee -> departmentId.equals(employee.getDepartment()))
                .collect(Collectors.toList()).stream().min(Comparator.comparingInt(Employee::getSalary)).orElseGet(() -> null);
    }

    public Employee searchMaxSalary(Integer departmentId) {
        return employees.stream().filter(employee -> departmentId.equals(employee.getDepartment()))
                .collect(Collectors.toList()).stream().max(Comparator.comparingInt(Employee::getSalary)).orElseGet(() -> null);
    }

    public Map<Integer,List<Employee>> getEmploeeysGroupedByDepartments() {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }




}
