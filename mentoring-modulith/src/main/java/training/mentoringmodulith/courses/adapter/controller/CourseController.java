package training.mentoringmodulith.courses.adapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.mentoringmodulith.courses.application.inboundport.AnnouncementRequest;
import training.mentoringmodulith.courses.application.inboundport.CourseDto;
import training.mentoringmodulith.courses.application.inboundport.CourseQueryService;
import training.mentoringmodulith.courses.application.inboundport.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    private final CourseQueryService queryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void announce(@RequestBody AnnouncementRequest request) {
        service.announce(request);
    }

    @GetMapping
    public List<CourseDto> findAll() {
        return queryService.findAll();
    }
}
