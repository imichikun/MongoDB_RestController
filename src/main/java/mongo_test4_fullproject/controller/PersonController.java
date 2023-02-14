package mongo_test4_fullproject.controller;

import mongo_test4_fullproject.model.Person;
import mongo_test4_fullproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @GetMapping("/oneperson")
    public Person getOnePerson(@RequestBody Person person){
        return personService.getOnePerson(person);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> savePerson(@RequestBody Person person){
         personService.savePerson(person);
         return ResponseEntity.ok(HttpStatus.OK);
     }

    @PatchMapping("/update")
    public ResponseEntity<HttpStatus> updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deletePerson(@RequestBody Person person){
        personService.deletePerson(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}