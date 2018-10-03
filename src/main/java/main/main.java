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
import java.util.ArrayList;
import java.util.List;
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

// STEP 3
        Facade facade = new Facade(Persistence.createEntityManagerFactory("pu"));
        EntityManager em = facade.getEntityManager();
        CityInfo c1 = new CityInfo("2800", "Lyngby");

        Address a1 = new Address("Road 1", "Nice road yo");
        Address a2 = new Address("Road 2", "New road");
// STEP 3

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
// STEP 3
        System.out.println("Get all persons in the system: \n" + facade.getAllPersons());

        System.out.println("---");

        System.out.println("Get a person in the system from id: \n" + facade.getPerson(1));

        System.out.println("---");

        a1.setCityInfo(c1);
        Person p6 = new Person("testensen1@mail.dk", "Egon", "Testensen");
        p6.setAddress(a1);
        
        Phone phone = new Phone("911", "Sound of da police");
        List<Phone> phones = new ArrayList<>();
        phone.setPerson(p6);
        p6.setPhones(phones);
        p6.addPhone(phone);
        
        System.out.println(p6.getPhones());

        System.out.println("Add a person to the system: \n" + facade.addPerson(p6));
        System.out.println("---");

        System.out.println("Get a person contactinfo in the system from id: \n" + facade.getPersonContactInfo(2));

        System.out.println("---");

        System.out.println("Get all persons contactinfo in the system: \n" + facade.getAllPersonsContactInfo());

        System.out.println("---");

//        System.out.println("Get a person in the system from id: \n" + facade.deletePerson(p6));
// STEP 3
    }

}
