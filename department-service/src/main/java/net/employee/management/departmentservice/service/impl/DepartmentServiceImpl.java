package net.employee.management.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.employee.management.departmentservice.dto.DepartmentDto;
import net.employee.management.departmentservice.entity.Department;
import net.employee.management.departmentservice.repository.DepartmentRepository;
import net.employee.management.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;
    ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity
        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        // convert department jpa entity to department dto
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return  modelMapper.map(department, DepartmentDto.class);
    }
}
