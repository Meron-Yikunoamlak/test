package et.com.meron.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class EmployeeUpdateDto {


    private String name;
    private String tittle;
    private String department;


}
