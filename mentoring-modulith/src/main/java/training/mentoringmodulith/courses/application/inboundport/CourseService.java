package training.mentoringmodulith.courses.application.inboundport;

import org.jmolecules.architecture.hexagonal.Port;

@Port
public interface CourseService {
    void announce(AnnouncementRequest request);

    void enroll(EnrollmentRequest request);

    void employeeHasLeaved(long l);
}
