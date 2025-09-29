package training.mentoringmodulith.courses.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.mentoringmodulith.courses.application.inboundport.AnnouncementRequest;
import training.mentoringmodulith.courses.application.inboundport.CourseService;
import training.mentoringmodulith.courses.application.usecase.AnnouncementUseCase;

@Service
@RequiredArgsConstructor
public class CourseApplicationService implements CourseService {

    private final AnnouncementUseCase announcementUseCase;

    @Override
    public void announce(AnnouncementRequest request) {
        announcementUseCase.announce(request);
    }
}
