package training.mentoringmodulith.courses.adapter.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
}
