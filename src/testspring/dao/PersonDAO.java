/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testspring.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import testspring.model.Person;

/**
 *
 * @author 7
 */
@Repository
public interface PersonDAO {

    public void save(Person p);

    void delete(Person person);

    Long count();

    Person getPerson(String id);

    List<Person> getPersons(int start, int num);

    public List<Person> list();

}
