package et.com.meron.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * form validation on data entry of Employee model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistrationDto {


    @NotBlank(message = "id field can not be blank")
    @NotEmpty(message = "id field can not contain empty string")
    @NotNull(message = "id field can not be null")
    private String id;

    @NotBlank(message = "name field can not be blank")
    @NotEmpty(message = "name field can not contain empty string")
    @NotNull(message = "name field can not be null")
    @Length(message = "minimum length is 3", min = 3)
    private String name;

    @NotBlank(message = "title field can not be blank")
    @NotEmpty(message = "title field can not contain empty string")
    @NotNull(message = "title field can not be null")
    @Length(message = "digit length should be between 2 and 50", min = 2, max = 50)
    private String title;

    //LET SAY DEPARTMENT CAN BE NULL IN OUR EXAMPLE
    private String department;

}
