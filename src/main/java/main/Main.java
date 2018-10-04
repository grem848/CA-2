package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.Facade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main
{

    public static void main(String[] args)
    {

        Facade facade = new Facade(Persistence.createEntityManagerFactory("pu"));
        EntityManager em = facade.getEntityManager();

        // Persistence.generateSchema("pu", null); // STEP 1
         
// STEP 2 
//        CityInfo c1 = new CityInfo("2800", "Lyngby");
//
//        Address a1 = new Address("Road 1", "Nice road yo");
//        a1.setCityInfo(c1);
//
//
//
//
//        Person p1 = new Person("testensen1@mail.dk", "Egon", "Testensen");
//        p1.setAddress(a1);
//        a1.addPerson(p1);
//
//        Phone phone = new Phone("911", "Sound of da police");
//        p1.addPhone(phone);
//        phone.setPerson(p1);
//
//        System.out.println("Add a person to the system: \n" + facade.addPerson(p1));
//        
//        System.out.println("---");
//        
////        System.out.println("Get all persons in the system: \n" + facade.getAllPersons()); // WORKS IN POSTMAN
//
//        System.out.println("---");
//
//        System.out.println("Get a person in the system from id: \n" + facade.getPerson(1)); // WORKS IN POSTMAN
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        System.out.println(gson.toJson(facade.getPerson(1)));
          System.out.println(facade.getAllZipCodes());
//
//        System.out.println("---");
//
//        System.out.println("Get a person contactinfo in the system from id: \n" + facade.getPersonContactInfo(2));
//
//        System.out.println("---");
//
//        System.out.println("Get all persons contactinfo in the system: \n" + facade.getAllPersonsContactInfo());
//
//        System.out.println("---");
//
//        Person p7 = new Person("deletenson@mail.dk", "Ole", "Deletenson");
//        p7.setAddress(a1);
//        a1.addPerson(p7);
//        int i = 1;
//        long l = i;
//        p7.setId(l);
//
//        System.out.println("Edit person" + "\n" + facade.editPerson(p7));

// STEP 2
    }

}
