package training.mentoringmodulith.courses.application.inboundport;

import org.jmolecules.architecture.hexagonal.Port;

import java.util.List;

@Port
public interface CourseQueryService {

    List<CourseDto> findAll();
}
