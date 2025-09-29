package training.mentoringmodulith.courses.domain.courses;

public record CourseCode(String value) {

    public CourseCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Course code must not be null or blank!");
        }
    }
}
