package training.mentoringmodulith.courses.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import training.mentoringmodulith.courses.application.outboundport.repo.CourseRepository;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;
import training.mentoringmodulith.courses.domain.service.LeaveDomainService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeHasLeavedUseCase {

    private final CourseRepository repository;

    private final LeaveDomainService leaveDomainService;

    public void leave(EmployeeId employeeId) {
        List<Course> courses = repository.findAllEnrolled(employeeId);
        leaveDomainService.leave(courses, employeeId);
        for (Course course: courses) {
            repository.save(course);
        }
    }
}
