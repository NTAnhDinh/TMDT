package relationship.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import relationship.app.model.Skill;
import relationship.app.repository.SkillRepository;
@Service
public class SkillService {

	@Autowired
	SkillRepository skillRepository;

	public List<Skill> getAll() {
		return skillRepository.findAll();
	}

	public Skill getOne(long id) {
		return skillRepository.getOne(id);
	}
}
