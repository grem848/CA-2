/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.Phone;
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
//        Persistence.generateSchema("pu", null); // STEP 1

        Facade facade = new Facade(Persistence.createEntityManagerFactory("pu"));
        EntityManager em = facade.getEntityManager();
        CityInfo c1 = new CityInfo("2800", "Lyngby");
        
        Address a1 = new Address("Road 1", "Nice road yo");
        Address a2 = new Address("Road 2", "New road");
        
        

// STEP 2 
//        em.getTransaction().begin(); 
//        a1.setCityInfo(c1);
//        a2.setCityInfo(c1);
//        
//        Person p1 = new Person("test1@mail.dk", "Brian", "Larsson");
//        p1.setAddress(a2);
//        em.persist(p1);
//        Person p2 = new Person("test1@mail.dk", "Kurt", "Larsson");
//        p2.setAddress(a1);
//        em.persist(p2);
//
//        em.getTransaction().commit();
//        em.close();
// STEP 2




        System.out.println("Get all persons in the system: \n" + facade.getAllPersons());

        System.out.println("---");

        Person p6 = new Person();
        Integer i = 1;
        Long l = new Long(i);
        p6.setId(l);

        System.out.println("Get a person in the system from id: \n" + facade.getPerson(p6));

        System.out.println("---");


        a1.setCityInfo(c1);
        Person p7 = new Person("testensen1@mail.dk", "Egon", "Testensen");
        p7.setAddress(a1);
        Phone phone = new Phone("911", "Sound of da police");
        p7.addPhone(phone);
        System.out.println(p7.getPhones());

        System.out.println("Add a person to the system: \n" + facade.addPerson(p7));
        System.out.println("---");

//        System.out.println("Get a person in the system from id: \n" + facade.deletePerson(p6));

    }

}
