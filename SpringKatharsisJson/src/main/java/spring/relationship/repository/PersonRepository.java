package spring.relationship.repository;

import org.springframework.stereotype.Component;

import io.katharsis.repository.ResourceRepositoryV2;
import spring.relationship.model.Person;
@Component
public interface PersonRepository extends ResourceRepositoryV2<Person, Long> {

}
