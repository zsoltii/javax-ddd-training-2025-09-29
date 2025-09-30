package training.mentoringmodulith.courses.application.outboundport.gateway;


import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;

public interface EmployeesGateway {

    boolean existsById(EmployeeId employeeId);
}
