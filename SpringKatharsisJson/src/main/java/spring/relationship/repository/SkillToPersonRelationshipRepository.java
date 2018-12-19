package spring.relationship.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import spring.relationship.model.Person;
import spring.relationship.model.Skill;
@Component
public class SkillToPersonRelationshipRepository implements RelationshipRepositoryV2<Person, Long, Skill, Long> {
	@Autowired
	SkillRepository skillRepo;
	@Autowired
	PersonRepository perRepo;

	@Override
	public Class<Person> getSourceResourceClass() {
		return Person.class;
	}

	@Override
	public Class<Skill> getTargetResourceClass() {
		return Skill.class;
	}

	@Override
	public void setRelation(Person source, Long targetId, String fieldName) {
		Set<Skill> list = new HashSet<>();
		Skill s = skillRepo.findOne(targetId, new QuerySpec(Skill.class));
		list.add(s);
		source.setSkills(list);
		perRepo.save(source);
	}

	@Override
	public void setRelations(Person source, Iterable<Long> targetIds, String fieldName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRelations(Person source, Iterable<Long> targetIds, String fieldName) {
		Set<Skill> list = new HashSet<>();

		list.addAll(skillRepo.findAll(targetIds, new QuerySpec(Skill.class)));
		source.setSkills(list);
		perRepo.save(source);

	}

	@Override
	public void removeRelations(Person source, Iterable<Long> targetIds, String fieldName) {
		// TODO Auto-generated method stub

	}

	@Override
	public Skill findOneTarget(Long sourceId, String fieldName, QuerySpec querySpec) {
		return null;
	}

	@Override
	public ResourceList<Skill> findManyTargets(Long sourceId, String fieldName, QuerySpec querySpec) {
		Person person = perRepo.findOne(sourceId, new QuerySpec(Person.class));
		return querySpec.apply(person.getSkills());
	}

}
