package relationship.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import relationship.app.model.Person;
import relationship.app.model.Skill;
import relationship.app.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAll() {

		return personRepository.findAll();
	}

	public Person getOne1(long id) {
		
			return personRepository.getOne(id);
		
	}
}
