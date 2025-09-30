package training.mentoringmodulith.courses.domain.enrollments;

import org.jmolecules.ddd.annotation.ValueObject;

import java.time.LocalDateTime;

@ValueObject
public record EnrollmentVO(EmployeeId employeeId, LocalDateTime enrollmentDate) {
}
