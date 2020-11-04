package com.example.sbpgdocker.dao;

import com.example.sbpgdocker.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

//idemo reći springu da ova klasa mora biti instancirana kao bean pa da je možemo injectati u druge klase (stavimo @Repository)
//može se staviti i @Component, isto je, ali @Repository kaže da se ova klasa servira kao repository (skladište )
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId()
                        .equals(id))
                        .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> p =  selectPersonById(id);
        if(p.isEmpty()){
            return 0;
        }
        DB.remove(p.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                  int indexOfPersonToUpdate = DB.indexOf(person);
                  if(indexOfPersonToUpdate >= 0){
                      DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                      return 1;
                  }
                  return 0;
                })
                .orElse(0);

    }
}
