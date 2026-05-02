package re.cntt4.employeeanddepartment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import re.cntt4.employeeanddepartment.model.Employee;
import re.cntt4.employeeanddepartment.repository.EmployeeRepositor;
import re.cntt4.employeeanddepartment.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeRepositor employeeRepositor;

    @Override
    public void save(Employee employee) {
        employeeRepositor.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepositor.findAll(pageable);
    }

    public Page<Employee> searchEmployee(String keyword, Pageable pageable) {
        return employeeRepositor.findByNameContainingIgnoreCase(keyword, pageable);
    }
}
