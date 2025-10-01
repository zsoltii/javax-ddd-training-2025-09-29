package training.mentoringmodulith.courses.application.outboundport.gateway;


import org.jmolecules.architecture.hexagonal.Port;
import training.mentoringmodulith.courses.domain.enrollments.EmployeeId;

@Port
public interface EmployeesGateway {

    boolean existsById(EmployeeId employeeId);
}
