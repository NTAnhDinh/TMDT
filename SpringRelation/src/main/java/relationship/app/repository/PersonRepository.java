package relationship.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import relationship.app.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
}
