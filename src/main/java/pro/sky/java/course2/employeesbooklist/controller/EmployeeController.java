package pro.sky.java.course2.employeesbooklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeesbooklist.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeesbooklist.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.employeesbooklist.model.Employee;
import pro.sky.java.course2.employeesbooklist.exceptions.EmployeeStorageIsFullException;
import pro.sky.java.course2.employeesbooklist.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.add(firstName, lastName);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышен лимит сотрудников");
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Такой сотрудник уже существует");
        }
        return employeeService.add(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.remove(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.find(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }
        return employeeService.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> showEmployeeList() {
        return employeeService.showEmployeeList();
    }
}
