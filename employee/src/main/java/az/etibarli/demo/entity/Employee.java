package az.etibarli.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @Column(name = "email")
    private String email;
    @Column(name = "geneder")
    private String gender;
    @Column(name = "phone")
    private String phone;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "active")
    private Boolean active;

    @PrePersist
    private void init() {
        createdAt = LocalDateTime.now();
        active = Boolean.TRUE;
    }
}
