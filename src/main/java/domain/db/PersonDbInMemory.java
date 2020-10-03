package domain.db;

import domain.model.Person;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDbInMemory {
    private Map<String, Person> persons = new HashMap<>();

    public PersonDbInMemory () {
        Person administrator = new Person("admin", "admin@ucll.be", "t", "Ad", "Ministrator",
                LocalTime.of(12,30), LocalTime.of(16,30));
        Person Frederik = new Person("frederik", "f@hot.com", "t", "frederik", "ausloos", LocalTime.of(12,00), LocalTime.of(18,00));
        Person Lara = new Person("lara", "f@hot.com", "t", "lara", "barrezeele", LocalTime.of(11,30), LocalTime.of(15,30));
        Person Anouk = new Person("anouk", "f@hot.com", "t", "anouk", "ausloos", LocalTime.of(18,15), LocalTime.of(20,45));
        Person Yannick = new Person("yannick", "f@hot.com", "t", "yannick", "ausloos", LocalTime.of(15,20), LocalTime.of(22,00));
        Person Jamie = new Person("jamie", "f@hot.com", "t", "Jamie", "Vandenbalck", LocalTime.of(9,00), LocalTime.of(13,00));
        add(administrator);
        add(Frederik);
        add(Anouk);
        add(Lara);
        add(Jamie);
        add(Yannick);
    }

    public Person get(String personId){
        if(personId == null){
            throw new DbException("No id given");
        }
        return persons.get(personId);
    }

    public List<Person> getAll(){
        return new ArrayList<Person>(persons.values());
    }

    public void add(Person person){
        if(person == null){
            throw new DbException("No person given");
        }
        if (persons.containsKey(person.getUserid())) {
            throw new DbException("User already exists");
        }
        persons.put(person.getUserid(), person);
    }

    public void update(Person person){
        if(person == null){
            throw new DbException("No person given");
        }
        if(!persons.containsKey(person.getUserid())){
            throw new DbException("No person found");
        }
        persons.put(person.getUserid(), person);
    }

    public void delete(String personId){
        if(personId == null){
            throw new DbException("No id given");
        }
        persons.remove(personId);
    }

    public int getNumberOfPersons() {
        return persons.size();
    }
}
