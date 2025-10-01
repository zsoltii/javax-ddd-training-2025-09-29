package training.mentoringmodulith.courses.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.stereotype.Repository;
import training.mentoringmodulith.courses.adapter.repository.entities.CourseJpaEntity;
import training.mentoringmodulith.courses.adapter.repository.entities.EnrollmentJpaEntity;
import training.mentoringmodulith.courses.application.inboundport.dto.CourseDto;
import training.mentoringmodulith.courses.application.outboundport.repo.CourseRepository;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.CourseCode;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;
import training.mentoringmodulith.courses.domain.enrollments.Enrollment;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Adapter
public class DelegatingCourseRepository implements CourseRepository {

    private final CourseJpaRepository jpaRepository;

    @Override
    public void save(Course course) {
        var entity = toJpaEntity(course);
        jpaRepository.save(entity);
    }

    @Override
    public boolean existsWithCode(CourseCode code) {
        return jpaRepository.existsById(code.value());
    }

    @Override
    public List<CourseDto> findAll() {
        return jpaRepository.findAllDto(CourseDto.class);
    }

    @Override
    public Course findById(CourseCode courseCode) {
        var jpaEntity = jpaRepository.findByIdWithEnrollments(courseCode.value());
        return toDomainEntity(jpaEntity);
    }

    @Override
    public List<Course> findAllEnrolled(EmployeeId employeeId) {
        var jpaEntities = jpaRepository.findAllEnrolled(employeeId.value());
        return jpaEntities.stream().map(this::toDomainEntity).toList();
    }

    private CourseJpaEntity toJpaEntity(Course course) {
        var enrollmentEntities = course.getEnrollments().stream().map(enrollment ->
                new EnrollmentJpaEntity(enrollment.getId(), enrollment.getEmployee().value(), enrollment.getEnrollmentDate())).toList();
        var entity = new CourseJpaEntity(course.getCode().value(), course.getTitle(), course.getLimit());
        entity.addEnrollments(enrollmentEntities);
        return entity;
    }

    private Course toDomainEntity(CourseJpaEntity courseJpaEntity) {
        var enrollments = courseJpaEntity.getEnrollments().stream().map(enrollmentJpaEntity ->
                new Enrollment(new EmployeeId(enrollmentJpaEntity.getEmployee()), enrollmentJpaEntity.getEnrollmentDate())).toList();
        return new Course(new CourseCode(courseJpaEntity.getCode()), courseJpaEntity.getTitle(), courseJpaEntity.getLimit(), new ArrayList<>(enrollments));
    }
}
