package net.employee.management.employeeservice.controller;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import net.employee.management.employeeservice.dto.EmployeeDto;
import net.employee.management.employeeservice.dto.EmployeeWithDepartmentDto;
import net.employee.management.employeeservice.exception.ErrorDetails;
import net.employee.management.employeeservice.exception.ResourceNotFoundException;
import net.employee.management.employeeservice.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // save Employee api
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // get Employee Api
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeWithDepartmentDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeWithDepartmentDto employeeWithDepartmentDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeWithDepartmentDto, HttpStatus.OK);
    }



//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
//            ResourceNotFoundException exception,
//            WebRequest webRequest) {
//            ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
