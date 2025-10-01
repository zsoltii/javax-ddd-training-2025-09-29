package training.mentoringmodulith.courses.domain.enrollments;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record CourseCode(String value) {

    public CourseCode {
        if (value == null || value.isBlank() || value.length() < 2) {
            throw new IllegalArgumentException("Course code must not be null or blank and must be at least 2 characters long");
        }
    }
}
