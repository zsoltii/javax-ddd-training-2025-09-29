package training.mentoringmodulith.courses.adapter.ingateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import training.mentoringmodulith.courses.application.inboundport.CourseService;
import training.mentoringmodulith.employees.application.outbound.gateway.EmployeeHasLeaved;

@Component
@Slf4j
@AllArgsConstructor
public class EmployeeHasLeavedEventHandler {

    private final CourseService courseService;

    @EventListener
    public void handleEvent(EmployeeHasLeaved event) {
        log.info("Employee {} has left the system.", event.employeeId());
        courseService.employeeHasLeaved(event.employeeId());

    }
}
