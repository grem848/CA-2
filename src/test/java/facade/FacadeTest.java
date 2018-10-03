//
//package facade;
//
//import DTO.PersonDTO;
//import entity.Address;
//import entity.Person;
//import java.util.List;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//
//public class FacadeTest {
//    
//Facade fp = new Facade(Persistence.createEntityManagerFactory("pu"));
//
//    EntityManagerFactory emf;
//
//    
//    public FacadeTest() {
//        
//        
//    }
//    
//    @Before
//    public void setUp() {
//    }
//
//    /**
//     * Test of getEntityManager method, of class Facade.
//     */
//    @Test
//    public void testGetEntityManager() {
//    }
//
//
//    /**
//     * Test of getPerson method, of class Facade.
//     */
//    @Test
//    public void testGetPerson() {
//        System.out.println("getPerson");
//        Person p = fp.addPerson(new Person("hej@live.dk","Jens", "Madsen"));
//        assertEquals("Jens", fp.getPerson(1).getFirstName());
//    }
//
//    /**
//     * Test of getAllPersons method, of class Facade.
//     */
//    @Test
//    public void testGetAllPersons() {
//         Person s =   fp.addPerson(new Person("gg@live.dk","John", "Winter"));
//        System.out.println("GETALLPERSONS");
//        System.out.println("persons");
//        assertTrue(fp.getAllPersons().contains(new PersonDTO(1L,"gg@live.dk", "John","Winter",null,null,null)));
//        
//        
//    }
//
//    /**
//     * Test of getAllPersonsContactInfo method, of class Facade.
//     */
//    @Test
//    public void testGetAllPersonsContactInfo() {
////                  System.out.println("AddPersonGetPersons");
////           Person s = fp.addPerson(new Person("gg@live.dk","Great", "Winter"));
////           
////        System.out.println("get all contact info");
////        List<PersonDTO> persons2 = fp.getAllPersonsContactInfo();
////        System.out.println(persons2);
////        
////        assertTrue(persons2.contains(new PersonDTO(1L,"gg@live.dk", "Great","Winter",null,null,null)));
////           fp.deletePerson(s);
//    }
//
//    /**
//     * Test of addPerson method, of class Facade.
//     */
//    @Test
//    public void testAddPerson() {
//        System.out.println("add person test");
//      Person p = new Person("hej@hej.dk","Jens", "West");
//        fp.addPerson(p);
//        assertEquals("Jens", fp.getPerson(p).getFirstName());
//        System.out.println(fp.getPerson(p).getFirstName());
//    }
//
//    /**
//     * Test of deletePerson method, of class Facade.
//     */
//
//    /**
//     * Test of editPerson method, of class Facade.
//     */
//    @Test
//    public void testEditPerson() {
////        System.out.println("Edit first name from Jake to Edited");
////        Person p = fp.addPerson(new Person("edit@live.dk","Jake","Whatever"));
////        System.out.println(fp.getPerson(p).getFirstName());
////        fp.editPerson(p);
//        
//    }
//    
//}