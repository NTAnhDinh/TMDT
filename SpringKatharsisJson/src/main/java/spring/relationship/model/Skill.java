package spring.relationship.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.SerializeType;

@JsonApiResource(type = "skills")
public class Skill {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonApiId
	@Column(name = "skill_id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "level")
	private String level;
	
     @JsonApiRelation(serialize=SerializeType.EAGER)
     private Person person;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", level=" + level + ", person=" + person + "]";
	}

	public Skill(long id, String name, String level, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.person = person;
	}
     public Skill() {
	}
     
}
