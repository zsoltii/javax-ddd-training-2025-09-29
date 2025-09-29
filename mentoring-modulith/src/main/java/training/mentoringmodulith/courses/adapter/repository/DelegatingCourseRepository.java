package training.mentoringmodulith.courses.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import training.mentoringmodulith.courses.application.CourseRepository;
import training.mentoringmodulith.courses.domain.courses.Course;

@Repository
@RequiredArgsConstructor
public class DelegatingCourseRepository implements CourseRepository {

    private final CourseJpaRepository jpaRepository;

    @Override
    public void save(Course course) {
        var jpa = new CourseJpaEntity(course.getCode().value(), course.getTitle());
        jpaRepository.save(jpa);
    }
}
