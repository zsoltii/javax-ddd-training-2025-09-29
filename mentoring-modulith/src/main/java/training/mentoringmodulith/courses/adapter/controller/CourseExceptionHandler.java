package training.mentoringmodulith.courses.adapter.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@ControllerAdvice
public class CourseExceptionHandler {

    @ExceptionHandler
    public ProblemDetail handle(IllegalArgumentException e) {
        var problem = ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(409), e.getMessage());
        problem.setProperty("error-id", UUID.randomUUID().toString());
        return problem;
    }
}
