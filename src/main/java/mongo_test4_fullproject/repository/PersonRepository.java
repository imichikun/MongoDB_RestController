package mongo_test4_fullproject.repository;

import mongo_test4_fullproject.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

//    List<Person> findByUsername(String username);
}