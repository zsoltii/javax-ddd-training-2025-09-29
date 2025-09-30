package training.mentoringmodulith.courses.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import training.mentoringmodulith.courses.application.inboundport.CourseDto;
import training.mentoringmodulith.courses.application.outboundport.CourseRepository;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.CourseCode;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DelegatingCourseRepository implements CourseRepository {

    private final CourseJpaRepository jpaRepository;

    @Override
    public void save(Course course) {
        var jpa = new CourseJpaEntity(course.getCode().value(), course.getTitle());
        jpaRepository.save(jpa);
    }

    @Override
    public boolean existsWithCode(CourseCode code) {
        return jpaRepository.existsById(code.value());
    }

    @Override
    public List<CourseDto> findAll() {
        return jpaRepository.findAllDto();
    }

    @Override
    public Course findById(CourseCode courseCode) {
        return jpaRepository.findByIdWithEnrollments(courseCode.value());
    }
}
