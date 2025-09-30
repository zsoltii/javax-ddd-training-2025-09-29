package training.mentoringmodulith.courses.adapter.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "enrollments")
public class EnrollmentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long employeeId;

    private LocalDateTime enrollmentDate;

    @ManyToOne
    private CourseJpaEntity course;
}
