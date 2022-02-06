package az.etibarli.demo.dto.response;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmployeeResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String gender;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean active;
}
