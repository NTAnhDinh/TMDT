package relationship.app.Controller;

//import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import relationship.app.model.Person;
import relationship.app.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(value = "/{id}")
	public Person getList(@PathVariable("id") int id) {
		return personService.getOne1(id);
	}
}
