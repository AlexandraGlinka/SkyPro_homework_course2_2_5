package pro.sky.java.course2.employeesbooklist.service;

import pro.sky.java.course2.employeesbooklist.model.Employee;

import java.text.CollationKey;
import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> showEmployeeList();
}

