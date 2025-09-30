package training.mentoringmodulith.courses.application.inboundport;

import org.jmolecules.architecture.hexagonal.Port;
import training.mentoringmodulith.courses.application.inboundport.dto.AnnouncementRequest;
import training.mentoringmodulith.courses.application.inboundport.dto.EnrollmentRequest;

@Port
public interface CourseService {
    void announce(AnnouncementRequest request);

    void enroll(EnrollmentRequest request);

    void employeeHasLeaved(long l);
}
