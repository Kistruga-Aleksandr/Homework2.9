package pro.sky.Homework29.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Homework29.Employee;
import pro.sky.Homework29.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/remove")
    public List<Employee> removeEmployee(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName, @RequestParam("salary") Integer salary,
                                         @RequestParam("department") Integer department) {
        return employeeService.removeEmployee(lastName, firstName, salary, department);
    }

    @GetMapping(path = " /find")
    public List<Employee> getEmployee(@RequestParam("lastName") String lastName,
                                      @RequestParam("firstName") String firstName,
                                      @RequestParam("salary") Integer salary,
                                      @RequestParam("department") Integer department) {

        return employeeService.getEmployee(lastName, firstName, salary, department);
    }

    @GetMapping()
    public Map<Integer, List<Employee>> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> getEmployeesByiDepartmentID(@RequestParam Integer departmentId) {
        return employeeService.getEmployeesByiDepartmentID(departmentId);
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee searchMinSalary(@RequestParam Integer departmentId) {
        return employeeService.searchMinSalary(departmentId);
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee searchMaxSalary(@RequestParam Integer departmentId) {
        return employeeService.searchMaxSalary(departmentId);
    }
}
