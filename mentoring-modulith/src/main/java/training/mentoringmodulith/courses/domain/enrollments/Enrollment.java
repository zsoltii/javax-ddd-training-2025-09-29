package training.mentoringmodulith.courses.domain.enrollments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
public class Enrollment {

    @Identity
    private Long id;

    private final EmployeeId employee;

    private final LocalDateTime enrollmentDate;

    public Enrollment(@NonNull EmployeeId employee, @NonNull LocalDateTime enrollmentDate) {
        this.employee = employee;
        this.enrollmentDate = enrollmentDate;
    }
}
