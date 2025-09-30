package training.mentoringmodulith.courses.domain.enrollments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseTest {

    @Test
    void announce() {
        var code = new CourseCode("JAVAX-DDD");
        var title = "Programozzunk DDD-vel";
        var course = Course.announce(code, title, 15);
        assertEquals(code, course.getCode());
        assertEquals(title, course.getTitle());
    }

    @Nested
    class EnrollmentsTest {

        Course course;

        @BeforeEach
        void setUp() {
            var code = new CourseCode("JAVAX-DDD");
            var title = "Programozzunk DDD-vel";
            course = Course.announce(code, title, 15);
        }

        @Test
        void enroll() {
            var id = new EmployeeId(10);
            course.enroll(id);
            assertThat(course.getEnrollmentVOs())
                .extracting(EnrollmentVO::employeeId)
                .containsExactly(id);
        }

        @Test
        void duplicateEnroll() {
            var id = new EmployeeId(10);
            course.enroll(id);
            assertThrows(IllegalStateException.class, () -> course.enroll(id));
        }

        @Test
        void full() {
            for (int i = 0; i < course.getLimit(); i++) {
                course.enroll(new EmployeeId(i + 1));
            }
            assertThrows(IllegalStateException.class, () -> course.enroll(new EmployeeId(16)));
        }


    }
}
