package net.employee.management.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithDepartmentDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
