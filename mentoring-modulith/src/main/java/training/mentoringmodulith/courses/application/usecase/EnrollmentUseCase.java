package training.mentoringmodulith.courses.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import training.mentoringmodulith.courses.application.inboundport.EnrollmentRequest;
import training.mentoringmodulith.courses.application.outboundport.CourseRepository;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.CourseCode;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;

@Component
@RequiredArgsConstructor
public class EnrollmentUseCase {

    private final CourseRepository repository;

    public void enroll(EnrollmentRequest request) {
        Course course = repository.findById(new CourseCode(request.courseCode()));
        course.enroll(new EmployeeId(request.employeeId()));
        repository.save(course);
    }
}
