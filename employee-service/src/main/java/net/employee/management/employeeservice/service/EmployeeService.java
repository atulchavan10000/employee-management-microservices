package net.employee.management.employeeservice.service;

import net.employee.management.employeeservice.dto.EmployeeDto;
import net.employee.management.employeeservice.dto.EmployeeWithDepartmentDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeWithDepartmentDto getEmployeeById(Long employeeId);
}
