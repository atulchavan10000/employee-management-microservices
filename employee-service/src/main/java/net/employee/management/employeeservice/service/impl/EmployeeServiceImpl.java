package net.employee.management.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.employee.management.employeeservice.dto.DepartmentDto;
import net.employee.management.employeeservice.dto.EmployeeDto;
import net.employee.management.employeeservice.dto.EmployeeWithDepartmentDto;
import net.employee.management.employeeservice.entity.Employee;
import net.employee.management.employeeservice.exception.ResourceNotFoundException;
import net.employee.management.employeeservice.repository.EmployeeRepository;
import net.employee.management.employeeservice.service.APIClient;
import net.employee.management.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private APIClient apiClient;
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    // orElseThrow method returns Entity
    // it expects supplier function interface implementation in paramter
    // therefore we can use lambda expression to implement supplier functional interface
    @Override
    public EmployeeWithDepartmentDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        EmployeeWithDepartmentDto apiResponseDto = new EmployeeWithDepartmentDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
