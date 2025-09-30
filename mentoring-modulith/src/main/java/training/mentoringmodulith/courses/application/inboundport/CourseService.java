package training.mentoringmodulith.courses.application.inboundport;

public interface CourseService {
    void announce(AnnouncementRequest request);

    void enroll(EnrollmentRequest request);
}
