/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Address;
import entity.CityInfo;
import entity.Person;
import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mohammahomarhariri
 */
public class main
{

    public static void main(String[] args)
    {
        //Persistence.generateSchema("pu", null);

        Facade facade = new Facade(Persistence.createEntityManagerFactory("pu"));
        EntityManager em = facade.getEntityManager();

        em.getTransaction().begin();
        CityInfo c1 = new CityInfo("2800", "Lyngby");
        
        Address a1 = new Address("Road 1", "Nice road yo", c1);
        Address a2 = new Address("Road 2", "New road", c1);
        
        
        Person p1 = new Person("test1@mail.dk", "Brian", "Larsson", a2);
        p1.setAddress(a2);
        p1.setAddress(a1);
        em.persist(p1);
        Person p2 = new Person("test1@mail.dk", "Kurt", "Larsson", a2);
        em.persist(p2);
        Person p3 = new Person("test1@mail.dk", "Jan", "Larsson", a2);
        em.persist(p3);
        Person p4 = new Person("test1@mail.dk", "Ole", "Larsson", a2);
        em.persist(p4);
        Person p5 = new Person("test1@mail.dk", "Ulla", "Larsson", a2);
        em.persist(p5);

        em.getTransaction().commit();
        em.close();

        System.out.println("Get all persons in the system: \n" + facade.getAllPersons());

        System.out.println("---");

    }

}
