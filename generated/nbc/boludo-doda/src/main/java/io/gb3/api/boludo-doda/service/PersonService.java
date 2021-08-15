package io.gb3.api.boludo-doda.service;

import java.util.List;
import java.util.Optional;

import io.gb3.api.boludo-doda.model.Person;
import io.gb3.api.boludo-doda.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepo;

	public Person findByName(String name, String surname) {
		return personRepo.findByNameAndSurname(name, surname);
	}

	public List<Person> findBySurnameLike(String surname) {
		return personRepo.findBySurnameLike(surname);
	}

	public Person save(Person person) {
		return personRepo.save(person);
	}

	public void delete(String id) {
		Optional<Person> person = personRepo.findById(id);
		if (person.isPresent()) {
			personRepo.delete(person.get());
		}
	}

}
