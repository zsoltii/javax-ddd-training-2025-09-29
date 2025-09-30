package training.mentoringmodulith.courses.adapter.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    private int limit;

    @OneToMany(mappedBy = "course")
    private List<EnrollmentJpaEntity> enrollments = new ArrayList<>();
}
