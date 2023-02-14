package mongo_test4_fullproject.service;

import mongo_test4_fullproject.model.Person;
import mongo_test4_fullproject.repository.PersonRepository;
import mongo_test4_fullproject.util.NoSuchPersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PersonService(PersonRepository personRepository, MongoTemplate mongoTemplate) {
        this.personRepository = personRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getOnePerson(Person person) {
        Query query = new Query(Criteria.where("name").is(person.getName()));
        Person possiblePerson = mongoTemplate.findOne(query, Person.class);

        if (possiblePerson == null)
            throw new NoSuchPersonException("No such Person in DB !");

        return possiblePerson;
    }

    public void savePerson(Person person){
        personRepository.save(person);
//        mongoTemplate.insert(person, "person");   // alternative variant for saving person
    }

    public void updatePerson(Person person) {
        Query searchPerson = new Query(Criteria.where("name").is(person.getName()));
        UpdateDefinition update = new Update().set("age", person.getAge());
        mongoTemplate.updateFirst(searchPerson, update, Person.class); // syntax for updating record (new age) in MongoDB
    }

    public void deletePerson(Person person) {
        Person possiblePerson = mongoTemplate.findOne(Query.query(Criteria.where("name").is(person.getName())), Person.class);

        if (possiblePerson == null)
            throw new NoSuchPersonException("No such Person in DB !");

        personRepository.delete(possiblePerson);
    }
}