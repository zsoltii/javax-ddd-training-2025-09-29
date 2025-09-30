package training.mentoringmodulith.courses.domain.enrollments;

import lombok.Getter;
import lombok.NonNull;
import org.jmolecules.ddd.annotation.Entity;

import java.time.LocalDateTime;

@Entity
@Getter
public class Enrollment {

    private final EmployeeId employee;

    private final LocalDateTime enrollmentDate;

    public Enrollment(@NonNull EmployeeId employee, @NonNull LocalDateTime enrollmentDate) {
        this.employee = employee;
        this.enrollmentDate = enrollmentDate;
    }
}
