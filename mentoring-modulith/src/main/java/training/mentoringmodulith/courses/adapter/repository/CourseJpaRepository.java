package training.mentoringmodulith.courses.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training.mentoringmodulith.courses.application.inboundport.CourseDto;
import training.mentoringmodulith.courses.domain.enrollments.Course;

import java.util.List;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, String> {
    @Query("""
            select new training.mentoringmodulith.courses.application.inboundport.CourseDto(
                    c.code,
                    c.title) from CourseJpaEntity c order by c.code
        """)
    List<CourseDto> findAllDto();

    @Query("""
        select c from CourseJpaEntity c left join fetch c.enrollments where
            c.code = :code
    """)
    CourseJpaEntity findByIdWithEnrollments(String code);
}
