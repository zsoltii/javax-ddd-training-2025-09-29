package training.mentoringmodulith.courses.adapter.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "courses")
public class CourseJpaEntity {

    @Id
    private String code;

    private String title;

    @Column(name = "enrollment_limit")
    private int limit;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollmentJpaEntity> enrollments = new ArrayList<>();

    public CourseJpaEntity(String code, String title, int limit) {
        this.code = code;
        this.title = title;
        this.limit = limit;
    }

    public void addEnrollment(EnrollmentJpaEntity enrollment) {
        this.enrollments.add(enrollment);
        enrollment.setCourse(this);
    }

    public void addEnrollments(List<EnrollmentJpaEntity> enrollmentEntities) {
        for (var enrollment: enrollmentEntities) {
            addEnrollment(enrollment);
        }
    }
}
