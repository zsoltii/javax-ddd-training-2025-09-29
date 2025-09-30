package training.mentoringmodulith.courses.domain.enrollments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
public class Enrollment {

    private final EmployeeId employee;

    private final LocalDateTime enrollmentDate;

    public Enrollment(@NonNull EmployeeId employee, @NonNull LocalDateTime enrollmentDate) {
        this.employee = employee;
        this.enrollmentDate = enrollmentDate;
    }
}
