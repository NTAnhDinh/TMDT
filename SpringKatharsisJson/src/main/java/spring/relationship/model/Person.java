package spring.relationship.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.SerializeType;

@Entity
@JsonApiResource(type = "peoples")
public class Person {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonApiId
	@Column(name = "person_id")
	long person_id;
	@Column(name = "name")
	String name;
	@Column(name = "age")
	int age;
	@JsonApiRelation(serialize = SerializeType.EAGER)
	private Set<Skill> skills;

	public Person() {
	}

	public Person(long person_id, String name, int age, Set<Skill> skills) {
		super();
		this.person_id = person_id;
		this.name = name;
		this.age = age;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", name=" + name + ", age=" + age + ", skills=" + skills + "]";
	}

	public long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(long person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

}
