package training.mentoringmodulith.courses.adapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.mentoringmodulith.courses.application.inboundport.*;
import training.mentoringmodulith.courses.application.inboundport.dto.AnnouncementRequest;
import training.mentoringmodulith.courses.application.inboundport.dto.CourseDto;
import training.mentoringmodulith.courses.application.inboundport.dto.EnrollmentRequest;

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

    @PostMapping("/{courseCode}/enrollments")
    @ResponseStatus(HttpStatus.CREATED)
    public void enroll(@PathVariable String courseCode, @RequestBody EnrollmentRequest request) {
        if (!courseCode.equals(request.courseCode())) {
            throw new IllegalArgumentException("Course code in path and request body don't match!");
        }
        service.enroll(request);
    }
}
