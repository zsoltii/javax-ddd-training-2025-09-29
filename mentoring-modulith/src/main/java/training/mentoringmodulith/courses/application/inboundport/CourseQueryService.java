package training.mentoringmodulith.courses.application.inboundport;

import org.jmolecules.architecture.hexagonal.Port;
import training.mentoringmodulith.courses.application.inboundport.dto.CourseDto;

import java.util.List;

@Port
public interface CourseQueryService {

    List<CourseDto> findAll();
}
