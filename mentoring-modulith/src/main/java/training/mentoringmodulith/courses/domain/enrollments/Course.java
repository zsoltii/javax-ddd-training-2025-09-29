package training.mentoringmodulith.courses.domain.enrollments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class Course {

    private final CourseCode code;

    private final String title;

    private final int limit;

    private List<Enrollment> enrollments = new ArrayList<>();

    private Course(CourseCode code, String title, int limit) {
        Objects.requireNonNull(code, "Course code must not be null!");
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title must not be null or blank!");
        }
        if (limit < 1) {
            throw new IllegalArgumentException("Course limit must be at least 1!");
        }
        this.code = code;
        this.title = title;
        this.limit = limit;
    }

    public static Course announce(CourseCode code, String title, int limit) {
        return new Course(code, title, limit);
    }

    public EnrollmentVO enroll(EmployeeId employeeId) {
        Objects.requireNonNull(employeeId, "Employee ID must not be null!");
        if (enrollments.stream().anyMatch(e -> e.getEmployee().equals(employeeId))) {
            throw new IllegalStateException("Employee %s is already enrolled in course %s!".formatted(
                    employeeId.value(), code.value()));
        }
        if (limit == enrollments.size()) {
            throw new IllegalStateException("Course %s is already full!".formatted(code.value()));
        }
        var enrollment = new Enrollment(employeeId, LocalDateTime.now());
        enrollments.add(enrollment);
        return new EnrollmentVO(employeeId, enrollment.getEnrollmentDate());
    }

    public List<EnrollmentVO> getEnrollmentVOs() {
        return enrollments.stream()
                .map(e -> new EnrollmentVO(e.getEmployee(), e.getEnrollmentDate()))
                .toList();
    }
}
