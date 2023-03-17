package et.com.meron.service.employeeService;

import et.com.meron.Dto.EmployeeRegistrationDto;
import et.com.meron.Dto.EmployeeUpdateDto;
import et.com.meron.Dto.ResponseDto;
import et.com.meron.model.Employee;
import et.com.meron.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final UtilityService utilityService;


    /**
     * Creating an employee / employee registration
     *
     * @param employeeRegistrationDto
     * @return
     */
    public ResponseEntity<ResponseDto> create(EmployeeRegistrationDto employeeRegistrationDto) {
        Optional<Employee> existingEmployee = employeeRepository.findByName(employeeRegistrationDto.getName());
        if (existingEmployee.isPresent())
            return ResponseEntity.ok(new ResponseDto<Employee>("this Employee already registered", null));

        Employee employee = new Employee();
        employee.setId(employeeRegistrationDto.getId());
        employee.setName(employeeRegistrationDto.getName());
        employee.setTittle(employeeRegistrationDto.getTitle());
        employee.setDepartment(employeeRegistrationDto.getDepartment());
        employeeRepository.save(employee);
        return ResponseEntity.ok(new ResponseDto<>("registered successfully", employee));

    }


    /**
     * Updating employee information
     * <p>
     * here the question was to update employee's name.
     * But, i create an api increase updating additional fields like title and department is necessary.
     *
     * @param id
     * @param employeeUpdateDto
     * @return
     */
    public ResponseEntity<ResponseDto> update(String id, EmployeeUpdateDto employeeUpdateDto) {
        var referenceObject = new Object() {
            ResponseEntity<ResponseDto> responseEntity;
        };
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        existingEmployee.ifPresentOrElse(
                (employee) -> {
                    if (employeeUpdateDto.getName() != null)
                        employee.setName(employeeUpdateDto.getName());
                    if (employeeUpdateDto.getTittle() != null)
                        employee.setTittle(employeeUpdateDto.getTittle());
                    if (employeeUpdateDto.getDepartment() != null)
                        employee.setDepartment(employeeUpdateDto.getDepartment());

                    employeeRepository.save(employee);
                    referenceObject.responseEntity = ResponseEntity.ok(new ResponseDto("updated successfully", employee));
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee id -> " + id + " not found");
                });
        return referenceObject.responseEntity;
    }


    /**
     * Deleting an employee (removing the record from database)
     *
     * @param id
     * @return
     */
    public ResponseEntity<ResponseDto> delete(String id) {
        var ref = new Object() { ResponseEntity<ResponseDto> responseEntity;};

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        optionalEmployee.ifPresentOrElse((employee) -> {
                    employeeRepository.delete(employee);
                    ref.responseEntity = ResponseEntity.ok(new ResponseDto<>("deleted successfully", null));
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee id -> " + id + " not found");
                }
        );
        return ref.responseEntity;
    }




    /**
     * getting Employee details by employee id
     *
     * @param id
     * @return : employee detail (employee model)
     */
    public ResponseEntity<Employee> getById(String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee id -> " + id + " not found");
        Employee employee = optionalEmployee.get();
        return ResponseEntity.ok(employee);
    }



    /**
     * getting Employee details by employee id
     *
     * @return
     */
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return ResponseEntity.ok(employeeList);
    }




    /**
     * Getting all registered Employees paginated data using searching parameters and sorting orders
     *
     * @param page
     * @param size
     * @param param
     * @param order
     * @return
     */
    public ResponseEntity<Page<Employee>> getPaginated(int page, int size, String param, String order) {
        return ResponseEntity.ok(employeeRepository.findAll(utilityService.pageable(page, size, order, param)));
    }


}
