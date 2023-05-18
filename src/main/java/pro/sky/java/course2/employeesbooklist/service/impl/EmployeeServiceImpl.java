package pro.sky.java.course2.employeesbooklist.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeesbooklist.Employee;
import pro.sky.java.course2.employeesbooklist.service.EmployeeService;
import pro.sky.java.course2.employeesbooklist.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Pavlov"),
            new Employee("Petr", "Petrovich"),
            new Employee("Alexandr", "Gavrilov"),
            new Employee("Vasilisa", "Andreeva")
    )
    );
    public int maxCount = 6;

    @Override
    public void add(Employee employee) {
        if (employees.size() >= maxCount) {
            throw new EmployeeStorageIsFullException(); // превышен лимит количества сотрудников в фирме
        } else {
            employees.add(employee);
        }
        ;
    }
}


//    public String findEmployee(String firstName, String lastName) {
//        final Employee employee = new Employee(firstName, lastName);
//        if (employee.getFirstName()) {
//        }
//        employees.get(employee);
//    }

//    @Override
//    public String showEmployeeList() {
//        return "";
//    }
//

