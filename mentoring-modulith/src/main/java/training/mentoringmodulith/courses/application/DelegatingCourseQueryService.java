package training.mentoringmodulith.courses.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.mentoringmodulith.courses.application.inboundport.CourseDto;
import training.mentoringmodulith.courses.application.inboundport.CourseQueryService;
import training.mentoringmodulith.courses.application.outboundport.CourseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DelegatingCourseQueryService implements CourseQueryService {

    private final CourseRepository repository;

    @Override
    public List<CourseDto> findAll() {
        return repository.findAll();
    }
}
