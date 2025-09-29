package training.mentoringmodulith.courses.domain.courses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseTest {

    @Test
    void announce() {
        var code = new CourseCode("JAVAX-DDD");
        var title = "Programozzunk DDD-vel";
        var course = Course.announce(code, title);
        assertEquals(code, course.getCode());
        assertEquals(title, course.getTitle());
    }
}
