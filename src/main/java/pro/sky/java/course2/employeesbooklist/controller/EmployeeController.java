package pro.sky.java.course2.employeesbooklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeesbooklist.Employee;
import pro.sky.java.course2.employeesbooklist.exceptions.EmployeeStorageIsFullException;
import pro.sky.java.course2.employeesbooklist.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firtName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.add(employee);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышен лимит сотрудников");
        }
        employeeService.add(employee);
        return employee.toString();
    }
}
