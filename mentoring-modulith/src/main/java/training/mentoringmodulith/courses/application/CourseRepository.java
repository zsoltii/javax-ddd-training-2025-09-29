package training.mentoringmodulith.courses.application;

import training.mentoringmodulith.courses.domain.courses.Course;

public interface CourseRepository {
    void save(Course course);
}
