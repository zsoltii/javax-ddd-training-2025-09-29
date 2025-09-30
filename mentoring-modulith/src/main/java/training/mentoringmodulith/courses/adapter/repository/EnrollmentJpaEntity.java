package training.mentoringmodulith.courses.adapter.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "enrollments")
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long employee;

    private LocalDateTime enrollmentDate;

    @ManyToOne
    private CourseJpaEntity course;

    public EnrollmentJpaEntity(Long id, long employee, LocalDateTime enrollmentDate) {
        this.id = id;
        this.employee = employee;
        this.enrollmentDate = enrollmentDate;
    }
}
