package training.mentoringmodulith.courses.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, String> {
}
