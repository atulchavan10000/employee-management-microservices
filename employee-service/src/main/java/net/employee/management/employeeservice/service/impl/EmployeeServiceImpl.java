package net.employee.management.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.employee.management.employeeservice.dto.EmployeeDto;
import net.employee.management.employeeservice.entity.Employee;
import net.employee.management.employeeservice.repository.EmployeeRepository;
import net.employee.management.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return modelMapper.map(employee, EmployeeDto.class);
    }
}
