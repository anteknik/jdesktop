/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testspring;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testspring.dao.PersonDAO;
import testspring.dao.impl.PersonDaoHibernate;
import testspring.model.Person;
import testspring.service.PersonService;
import testspring.service.impl.PersonServiceImpl;

/**
 *
 * @author 7
 */
public class AppSpring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-spring.xml");
        //Person person = ctx.getBean("person", Person.class);
        //PersonDAO personDAO = ctx.getBean(PersonDAO.class);
        //PersonDaoHibernate personDAO = ctx.getBean(PersonDaoHibernate.class);
        PersonService personDAO = ctx.getBean(PersonService.class);

        Person person = new Person();

        //personDAO.save(person);

        //System.out.println("Person::" + person);
        Long total = personDAO.count();
        
        System.out.println(total);
        List<Person> list =personDAO.getPersons();

        for (Person p : list) {
            System.out.println("Person List::" + p);
        }
		//close resources

    }
}
