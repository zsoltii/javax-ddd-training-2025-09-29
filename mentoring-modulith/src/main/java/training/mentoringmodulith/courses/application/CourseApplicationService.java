package training.mentoringmodulith.courses.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.mentoringmodulith.courses.application.inboundport.AnnouncementRequest;
import training.mentoringmodulith.courses.application.inboundport.CourseService;
import training.mentoringmodulith.courses.application.inboundport.EnrollmentRequest;
import training.mentoringmodulith.courses.application.usecase.AnnouncementUseCase;
import training.mentoringmodulith.courses.application.usecase.EnrollmentUseCase;

@Service
@RequiredArgsConstructor
public class CourseApplicationService implements CourseService {

    private final AnnouncementUseCase announcementUseCase;

    private final EnrollmentUseCase enrollmentUseCase;

    @Override
    public void announce(AnnouncementRequest request) {
        announcementUseCase.announce(request);
    }

    @Override
    public void enroll(EnrollmentRequest request) {
        enrollmentUseCase.enroll(request);
    }
}
