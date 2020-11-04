package com.example.sbpgdocker.service;

import com.example.sbpgdocker.dao.PersonDao;
import com.example.sbpgdocker.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//može i ode ići @Component, ali ovako dajemo do znanja onome ko čita naš kod da je ovo Service
@Service
public class PersonService {

    private PersonDao personDao;

    //autowireamo ovo u PersonDao interfejs
    //moramo staviti Qualifier jer imamo više implementacija ovog interfejsa PersonDao pa da ih možemo razlikovati->
    //->ovo unutar Qualifiera 'fakeDao', isto pišemo unutar 'dao' paketa pod @Repository('fakeDao')->
    //->ovo nam služi npr ako imamo više implementacija baze pa onda možemo unutar ovog Qualifiera samo staviti 'postgres' umisto 'fakeDao' i onda radimo sa Postgresom
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }
}
