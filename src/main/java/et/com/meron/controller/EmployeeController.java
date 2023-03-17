package et.com.meron.controller;


import et.com.meron.Dto.EmployeeRegistrationDto;
import et.com.meron.Dto.EmployeeUpdateDto;
import et.com.meron.Dto.ResponseDto;
import et.com.meron.model.Employee;
import et.com.meron.service.employeeService.CustomValidation;
import et.com.meron.service.employeeService.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/employee")
@Tag(name = "Employee APIs")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CustomValidation customValidation;


    @PostMapping("/create")
    @Operation(summary = "All fields are required")
    public ResponseEntity<ResponseDto> create(@RequestBody EmployeeRegistrationDto employeeRegistrationDto) {
        Set<ConstraintViolation<EmployeeRegistrationDto>> violations = customValidation.getConstraintViolations(employeeRegistrationDto);
        if (!violations.isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDto(new ConstraintViolationException(violations).getMessage(), null));
        return employeeService.create(employeeRegistrationDto);
    }


    // HERE I USE PATCH  B/C ONLY PARTIAL MODIFICATION OR UPDATE IS REQUIRED ON EMPLOYEE MODEL
    // IF WE ARE UPDATING ALL FIELDS WE CAN USE PUT
    @PatchMapping("/update/{id}")
    @Operation(summary = "only the fields that needs to be updated, should be sent.")
    public ResponseEntity<ResponseDto> update(@PathVariable("id") String id,
                                              @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        Set<ConstraintViolation<EmployeeUpdateDto>> violations = customValidation.getConstraintViolations(employeeUpdateDto);
        if (!violations.isEmpty())
            return ResponseEntity.badRequest().body(new ResponseDto(new ConstraintViolationException(violations).getMessage(), null));
        return employeeService.update(id, employeeUpdateDto);
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "this will remove the user from db permanently")
    public ResponseEntity<ResponseDto> delete(@PathVariable("id") String id) {
        return employeeService.delete(id);
    }


    @GetMapping("/get/{id}")
    @Operation(summary = "gets Employee model details of the given id")
    public ResponseEntity<Employee> getById(@PathVariable("id") String id) {
        return employeeService.getById(id);
    }

    @GetMapping("/getAll")
    @Operation(summary = "gets all recorded employees")
    public ResponseEntity<List<Employee>> getById() {
        return employeeService.getAll();
    }


    @GetMapping("/all")
    @Operation(summary = "sorting orders must be sent as 'asc' and 'desc'. and sorting parameters" +
            "are User model field names")
    public ResponseEntity<Page<Employee>> getAllLessorReports(@RequestParam(value = "page", defaultValue = "0") int page,
                                                              @RequestParam(value = "size", defaultValue = "10") int size,
                                                              @RequestParam(value = "sortingParameter", defaultValue = "id") String param,
                                                              @RequestParam(value = "sortingOrder", defaultValue = "asc") String order) {
        return employeeService.getPaginated(page, size, param, order);
    }


}
