package net.employee.management.employeeservice.service;

import net.employee.management.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable String departmentCode);
}
