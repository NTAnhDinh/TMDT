package relationship.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import relationship.app.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	
}
