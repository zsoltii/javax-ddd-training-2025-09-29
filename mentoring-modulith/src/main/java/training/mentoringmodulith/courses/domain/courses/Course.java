package training.mentoringmodulith.courses.domain.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Course {

    private final CourseCode code;

    private final String title;

    private Course(CourseCode code, String title) {
        Objects.requireNonNull(code, "Course code must not be null!");
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title must not be null or blank!");
        }
        this.code = code;
        this.title = title;
    }

    public static Course announce(CourseCode code, String title) {
        return new Course(code, title);
    }
}
