//
//package facade;
//
//import DTO.PersonDTO;
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
//Facade fp = new Facade(Persistence.createEntityManagerFactory("jpapuTest"));
//
//    EntityManagerFactory emf;
//
//    
//    public FacadeTest() {
//                Persistence.generateSchema("jpapuTest", null);
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
////    @Test
////    public void testDeletePerson() {
////      
////        Person p = fp.addPerson(new Person("hej@live.dk","Kurt", "Madsen"));
////       
////        System.out.println("print out size before deletion");
////        System.out.println(fp.getAllPersons().size());
////        
////        
////        
////        
////        fp.deletePerson(p);
////        
////        List<PersonDTO> persons = fp.getAllPersons();
////        System.out.println("Print out size after 1 deletion");
////        System.out.println(persons.size());
////        assertEquals(2,persons.size());
////        
////    }
//    /**
//     * Test of getPerson method, of class Facade.
//     */
////    @Test
////    public void testGetPerson() {
////        System.out.println("getPerson");
////        Person p = fp.addPerson(new Person("hej@live.dk","Jens", "Madsen"));
////        assertEquals("Jens", fp.getPerson(p).getFirstName());
////    }
//
//    /**
//     * Test of getAllPersons method, of class Facade.
//     */
//    @Test
//    public void testGetAllPersons() {
//         Person s =   fp.addPerson(new Person("gg@live.dk","John", "Winter"));
//        System.out.println("GETALLPERSONS");
//        System.out.println("persons");
//        assertTrue(fp.getAllPersons().contains(new PersonDTO(s)));
//        
//        
//    }
//
//    /**
//     * Test of getAllPersonsContactInfo method, of class Facade.
//     */
//    @Test
//    public void testGetAllPersonsContactInfo() {
//        Person s =   fp.addPerson(new Person("123@live.dk","Kurt", "Winter"));
//        System.out.println("GETALLPERSONS");
//        System.out.println("persons");
//        assertTrue(fp.getAllPersons().contains(new PersonDTO(s)));
//    }
//
//    /**
//     * Test of addPerson method, of class Facade.
//     */
////    @Test
////    public void testAddPerson() {
////        System.out.println("add person test");
////      Person p = new Person("hej@hej.dk","Jens", "West");
////        fp.addPerson(p);
////        assertEquals("Jens", fp.getPerson(p).getFirstName());
////        System.out.println(fp.getPerson(p).getFirstName());
////    }
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