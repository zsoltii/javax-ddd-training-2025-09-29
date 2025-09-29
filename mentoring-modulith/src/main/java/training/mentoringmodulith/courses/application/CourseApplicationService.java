package training.mentoringmodulith.courses.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.mentoringmodulith.courses.application.inboundport.AnnouncementRequest;
import training.mentoringmodulith.courses.application.inboundport.CourseService;
import training.mentoringmodulith.courses.application.outboundport.CourseRepository;
import training.mentoringmodulith.courses.domain.courses.Course;
import training.mentoringmodulith.courses.domain.courses.CourseCode;

@Service
@RequiredArgsConstructor
public class CourseApplicationService implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void announce(AnnouncementRequest request) {
        var course = Course.announce(new CourseCode(request.code()), request.title());
        courseRepository.save(course);
    }
}
