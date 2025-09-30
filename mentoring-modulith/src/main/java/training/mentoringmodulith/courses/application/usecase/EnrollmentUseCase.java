package training.mentoringmodulith.courses.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import training.mentoringmodulith.courses.application.inboundport.EnrollmentRequest;
import training.mentoringmodulith.courses.application.outboundport.gateway.EmployeesGateway;
import training.mentoringmodulith.courses.application.outboundport.repo.CourseRepository;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.CourseCode;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;

@Component
@RequiredArgsConstructor
public class EnrollmentUseCase {

    private final CourseRepository repository;

    private final EmployeesGateway employeesGateway;

    public void enroll(EnrollmentRequest request) {
        var course = repository.findById(new CourseCode(request.courseCode()));
        var employeeId = new EmployeeId(request.employeeId());
        if (!employeesGateway.existsById(employeeId)) {
            throw new IllegalArgumentException("Employee with ID %d does not exist!".formatted(
                    employeeId.value()));
        }
        course.enroll(employeeId);
        repository.save(course);
    }
}
