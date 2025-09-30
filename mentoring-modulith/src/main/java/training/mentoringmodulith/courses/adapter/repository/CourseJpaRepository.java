package training.mentoringmodulith.courses.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training.mentoringmodulith.courses.adapter.repository.entities.CourseJpaEntity;
import training.mentoringmodulith.courses.application.inboundport.dto.CourseDto;

import java.util.List;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, String> {
    @Query("""
            select c from CourseJpaEntity c order by c.code
        """)
    <T> List<T> findAllDto(Class<T> type);

    @Query("""
        select c from CourseJpaEntity c left join fetch c.enrollments where
            c.code = :code
    """)
    CourseJpaEntity findByIdWithEnrollments(String code);

    @Query("""
        select distinct c from CourseJpaEntity c 
            left join fetch c.enrollments
        where c.code in (
            select e.course.code from EnrollmentJpaEntity e 
            where e.employee = :employeeId
        )
    """)

    List<CourseJpaEntity> findAllEnrolled(long employeeId);
}
