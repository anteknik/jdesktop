/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testspring.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import testspring.model.Person;

/**
 *
 * @author 7
 */
@Repository
public interface PersonService {
  void save(Person person);
  void delete(Person person);
  Long count();
  Person getPerson(Long id);
  List<Person> getPersons();
  List<Person> getPersons(int start, int num);
}

