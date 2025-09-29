package training.mentoringmodulith.courses.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import training.mentoringmodulith.courses.application.inboundport.AnnouncementRequest;
import training.mentoringmodulith.courses.application.outboundport.CourseRepository;
import training.mentoringmodulith.courses.domain.courses.Course;
import training.mentoringmodulith.courses.domain.courses.CourseCode;

@Component
@RequiredArgsConstructor
public class AnnouncementUseCase {

    private final CourseRepository courseRepository;

    public void announce(AnnouncementRequest request) {
        var code = new CourseCode(request.code());
        if (courseRepository.existsWithCode(code)) {
            throw new IllegalArgumentException("Course with code %s already exists!".formatted(
                    code.value()));
        }
        var course = Course.announce(code, request.title());
        courseRepository.save(course);
    }
}
