package training.mentoringmodulith.courses.application.outboundport.repo;

import org.jmolecules.architecture.hexagonal.Port;
import training.mentoringmodulith.courses.application.inboundport.dto.CourseDto;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.CourseCode;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;

import java.util.List;

@Port
public interface CourseRepository {
    void save(Course course);

    boolean existsWithCode(CourseCode code);

    List<CourseDto> findAll();

    Course findById(CourseCode courseCode);

    List<Course> findAllEnrolled(EmployeeId employeeId);
}
