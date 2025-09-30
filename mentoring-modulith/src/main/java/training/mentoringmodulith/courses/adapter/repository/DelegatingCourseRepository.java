package training.mentoringmodulith.courses.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.stereotype.Repository;
import training.mentoringmodulith.courses.application.inboundport.CourseDto;
import training.mentoringmodulith.courses.application.outboundport.repo.CourseRepository;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.CourseCode;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Adapter
public class DelegatingCourseRepository implements CourseRepository {

    private final CourseJpaRepository jpaRepository;

    private final CourseMapper courseMapper;

    @Override
    public void save(Course course) {
        var jpa = courseMapper.toEntity(course);
        for (var enrollment : jpa.getEnrollments()) {
            enrollment.setCourse(jpa);
        }
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
        var entity = jpaRepository.findByIdWithEnrollments(courseCode.value());
        return courseMapper.toDomain(entity);
    }

    @Override
    public List<Course> findAllEnrolled(EmployeeId employeeId) {
        return List.of();
    }
}
