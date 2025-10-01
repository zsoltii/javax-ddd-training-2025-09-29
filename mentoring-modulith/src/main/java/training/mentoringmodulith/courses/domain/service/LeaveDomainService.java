package training.mentoringmodulith.courses.domain.service;

import org.springframework.stereotype.Component;
import training.mentoringmodulith.courses.domain.enrollments.Course;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;

import java.util.List;

@Component
public class LeaveDomainService {

    public void leave(List<Course> courses, EmployeeId employeeId) {
        for (Course course : courses) {
            course.cancelEnrollment(employeeId);
        }
    }
}
