/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testspring.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testspring.dao.impl.PersonDaoHibernate;
import testspring.model.Person;
import testspring.service.PersonService;

/**
 *
 * @author 7
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService{
  @Autowired private PersonDaoHibernate personDao;
  @Transactional
  @Override
  public void save(Person person) {
    personDao.save(person);
  }
  @Transactional
  @Override
  public void delete(Person person) {
    personDao.delete(person);
  }
  @Override
  public Long count() {
    return personDao.count();
  }
  @Override
  public Person getPerson(Long id) {
    return personDao.getById(id);
  }
  @Override
  public List<Person> getPersons() {
    return personDao.getAll();
  }
  @Override
  public List<Person> getPersons(int start, int num) {
    return personDao.getAll(start, num);
  }

}
