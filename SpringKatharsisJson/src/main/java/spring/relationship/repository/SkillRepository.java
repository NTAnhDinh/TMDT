package spring.relationship.repository;

import org.springframework.stereotype.Component;

import io.katharsis.repository.ResourceRepositoryV2;
import spring.relationship.model.Skill;

@Component
public interface SkillRepository extends ResourceRepositoryV2<Skill, Long>{

}
