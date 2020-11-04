package com.example.sbpgdocker.api;

import com.example.sbpgdocker.model.Person;
import com.example.sbpgdocker.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//ode ćemo napisati endpointse koje će klijenti upotrebljavati
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    //sa ovim Autowire SB injecta aktualni service u ovaj konstruktor
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //želimo da ova metoda bude poslužena kao POST request
    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person personToUpdate){
        personService.updatePersonById(id, personToUpdate);
    }
}
