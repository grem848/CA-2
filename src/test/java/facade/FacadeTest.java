//package facade;
//
//import DTO.PersonDTO;
//import entity.Address;
//import entity.CityInfo;
//import entity.Person;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class FacadeTest {
//
//    Facade fp = new Facade(Persistence.createEntityManagerFactory("pusecond"));
//
//    EntityManagerFactory emf;
//
//    private static Connection testConnection;
//    private static final String USER = "root";
//    private static final String USERPW = "1cd5288";
//    private static final String DBNAME = "ca2test";
//    private static final String HOST = "localhost";
//    public FacadeTest() {
//    }
//
//    @Before
//    public void setUp(){
//
//             try {
//            // avoid making a new connection for each test
//            if (testConnection == null) {
//                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
//                Class.forName("com.mysql.jdbc.Driver");
//
//                testConnection = DriverManager.getConnection(url, USER, USERPW);
//                // Make mappers use test 
//                testConnector.setConnection((com.mysql.jdbc.Connection) testConnection);
//            }
//             try (Statement stmt = testConnection.createStatement()) {
//                
//                stmt.execute("SET FOREIGN_KEY_CHECKS=0;");
//                
//                stmt.execute("drop table if exists address");
//                stmt.execute("drop table if exists cityinfo");
//                stmt.execute("drop table if exists hobby");
//                stmt.execute("drop table if exists person");
//                stmt.execute("drop table if exists person_hobby");
//                stmt.execute("drop table if exists phone");
//              
//                
//                
//                stmt.execute("SET FOREIGN_KEY_CHECKS=1;");
//                 Persistence.generateSchema("pusecond", null);
//                 }
//        } catch (SQLException | ClassNotFoundException ex) {
//            testConnection = null;
//            System.out.println("Could not open connection to database: " + ex.getMessage());
//        }
//     
//            
//
//        }
//        @After
//        public void tearDown(){
//           
//            
//            
//        }
//
//        /**
//         * Test of getEntityManager method, of class Facade.
//         */
//        @Test
//        public void testGetEntityManager() {
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
////    }
////    
////    @Before
////    public void setUp() {
////    }
////
////    /**
////     * Test of getEntityManager method, of class Facade.
////     */
////    @Test
////    public void testGetEntityManager() {
////    }
////
//////    @Test
//////    public void testDeletePerson() {
//////      
//////        Person p = fp.addPerson(new Person("hej@live.dk","Kurt", "Madsen"));
//////       
//////        System.out.println("print out size before deletion");
//////        System.out.println(fp.getAllPersons().size());
//////        
//////        
//////        
//////        
//////        fp.deletePerson(p);
//////        
//////        List<PersonDTO> persons = fp.getAllPersons();
//////        System.out.println("Print out size after 1 deletion");
//////        System.out.println(persons.size());
//////        assertEquals(2,persons.size());
//////        
//////    }
////    /**
////     * Test of getPerson method, of class Facade.
////     */
//////    @Test
//////    public void testGetPerson() {
//////        System.out.println("getPerson");
//////        Person p = fp.addPerson(new Person("hej@live.dk","Jens", "Madsen"));
//////        assertEquals("Jens", fp.getPerson(p).getFirstName());
//////    }
////
////    /**
////     * Test of getAllPersons method, of class Facade.
////     */
////    @Test
////    public void testGetAllPersons() {
////         Person s =   fp.addPerson(new Person("gg@live.dk","John", "Winter"));
////        System.out.println("GETALLPERSONS");
////        System.out.println("persons");
////        assertTrue(fp.getAllPersons().contains(new PersonDTO(s)));
////        
////        
////    }
////
////    /**
////     * Test of getAllPersonsContactInfo method, of class Facade.
////     */
////    @Test
////    public void testGetAllPersonsContactInfo() {
////        Person s =   fp.addPerson(new Person("123@live.dk","Kurt", "Winter"));
////        System.out.println("GETALLPERSONS");
////        System.out.println("persons");
////        assertTrue(fp.getAllPersons().contains(new PersonDTO(s)));
////    }
////
////    /**
////     * Test of addPerson method, of class Facade.
////     */
//////    @Test
//////    public void testAddPerson() {
//////        System.out.println("add person test");
//////      Person p = new Person("hej@hej.dk","Jens", "West");
//////        fp.addPerson(p);
//////        assertEquals("Jens", fp.getPerson(p).getFirstName());
//////        System.out.println(fp.getPerson(p).getFirstName());
//////    }
////
////    /**
////     * Test of deletePerson method, of class Facade.
////     */
////
////    /**
////     * Test of editPerson method, of class Facade.
////     */
////    @Test
////    public void testEditPerson() {
//////        System.out.println("Edit first name from Jake to Edited");
//////        Person p = fp.addPerson(new Person("edit@live.dk","Jake","Whatever"));
//////        System.out.println(fp.getPerson(p).getFirstName());
//////        fp.editPerson(p);
////        
////    }
//    /**
//     * Test of getPerson method, of class Facade.
//     */
//    @Test
//        public void testGetPerson
//        
//            () {
//        System.out.println("getPerson");
//            System.out.println("add person test");
//            CityInfo c1 = new CityInfo("2800", "Lyngby");
//            Address a2 = new Address("Road 2", "New road");
//            a2.setCityInfo(c1);
////        
//            Person p1 = new Person("test1@mail.dk", "Frank", "Ls");
//            p1.setAddress(a2);
//            fp.addPerson(p1);
//
//            assertEquals("Frank", fp.getPerson(4).getFirstName());
//        }
////
////    /**
////     * Test of getAllPersons method, of class Facade.
////     */
//        @Test
//        public void testGetAllPersons
//        
//            () {
//          System.out.println("add person test");
//            CityInfo c1 = new CityInfo("2800", "Lyngby");
//            Address a2 = new Address("Road 2", "New road");
//            a2.setCityInfo(c1);
////        
//            Person p1 = new Person("test1@mail.dk", "All", "Persons");
//            p1.setAddress(a2);
//            fp.addPerson(p1);
//            System.out.println(fp.getAllPersons());
//            assertEquals(1, fp.getAllPersons().size());
//            assertTrue(fp.getAllPersons().contains(new PersonDTO(p1)));
////        
//        }
//
//        /**
//         * Test of getAllPersonsContactInfo method, of class Facade.
//         */
//        @Test
//        public void testGetAllPersonsContactInfo
//        
//            () {
//        CityInfo c1 = new CityInfo("2800", "Lyngby");
//            Address a2 = new Address("Road 2", "New road");
//            a2.setCityInfo(c1);
////        
//            Person p1 = new Person("contact@info.dk", "Every", "Human");
//            p1.setAddress(a2);
//            fp.addPerson(p1);
//            assertTrue(fp.getAllPersons().contains(new PersonDTO(p1)));
//        }
//
//        /**
//         * Test of addPerson method, of class Facade.
//         */
//        @Test
//        public void testAddPerson
//        
//            () {
//        System.out.println("add person test");
//            CityInfo c1 = new CityInfo("2800", "Lyngby");
//            Address a2 = new Address("Road 2", "New road");
//            a2.setCityInfo(c1);
////        
//            Person p1 = new Person("test1@mail.dk", "Kristian", "Ls");
//            p1.setAddress(a2);
//            fp.addPerson(p1);
//            assertEquals("Kristian", fp.getPerson(3).getFirstName());
//
//        }
//
//        /**
//         * Test of deletePerson method, of class Facade.
//         */
//        /**
//         * Test of editPerson method, of class Facade.
//         */
//        @Test
//        public void testEditPerson
//        
//        
//    
//
//() {
////        System.out.println("Edit first name from Jake to Edited");
////        Person p = fp.addPerson(new Person("edit@live.dk","Jake","Whatever"));
////        System.out.println(fp.getPerson(p).getFirstName());
////        fp.editPerson(p);
//        
//    }
//    
//}
//
