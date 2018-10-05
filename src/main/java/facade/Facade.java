package facade;

import DTO.ContactInfo;
import DTO.PersonDTO;
import entity.CityInfo;
import entity.Person;
import static entity.Person_.phones;

import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Facade
{

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public PersonDTO getPerson(String email)
    {
        EntityManager em = getEntityManager();

        PersonDTO p = null;

        try
        {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("Select new DTO.PersonDTO(p) from Person p where p.email = :email", PersonDTO.class);
            query.setParameter("email", email);
            p = query.getSingleResult();
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }
 
    public List<PersonDTO> getAllPersons()
    {
        EntityManager em = getEntityManager();

        List<PersonDTO> persons = null;

        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("SELECT NEW DTO.PersonDTO(p) from Person p", PersonDTO.class).getResultList();

            em.getTransaction().commit();
            return persons;
        } finally
        {
            em.close();
        }
    }
 
    public List<ContactInfo> getAllPersonsContactInfo()
    {
        EntityManager em = getEntityManager();

        List<ContactInfo> persons = null;

        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("SELECT NEW DTO.ContactInfo(p) from Person p", ContactInfo.class).getResultList();

            em.getTransaction().commit();
            return persons;
        } finally
        {
            em.close();
        }
    }

    public ContactInfo getPersonContactInfo(String email)
    {
        EntityManager em = getEntityManager();

        ContactInfo p = null;

        try
        {
            em.getTransaction().begin();
            TypedQuery<ContactInfo> query = em.createQuery("Select new DTO.ContactInfo(p) from Person p where p.email = :email", ContactInfo.class);
            query.setParameter("email", email);
            p = query.getSingleResult();
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }
        
   public ContactInfo getPersonInfoWithPhone(String number){
       
       EntityManager em = getEntityManager();
       
       ContactInfo p = null;
       
       try {
           em.getTransaction().begin();
           TypedQuery<ContactInfo> query = em.createQuery("select new DTO.ContactInfo(p) From Person p join p.phones ph where ph.number = :number", ContactInfo.class);
           query.setParameter("number", number);
           p = query.getSingleResult();
           em.getTransaction().commit();
           return p;
       }finally{
           em.close();
       }
       
   }

    public Person addPerson(Person p)
    {
        EntityManager em = getEntityManager();

        try
        {
            p.getAddress().setCityInfo(em.find(CityInfo.class, p.getAddress().getCityInfo().getZip()));
            List<Phone> plist = p.getPhones();
            for (Phone phone : plist)
            {
                phone.setPerson(p);
            }
            p.setPhones(plist);
            em.getTransaction().begin();
            em.persist(p);

            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    public Person editPerson(Person person)
    {
        EntityManager em = getEntityManager();

        try
        {
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Person p where p.email = :email", Person.class);
            query.setParameter("email", person.getEmail());
            Person p = (Person) query.getSingleResult();
            if (p != null)
            {
//                Query query2 = em.createNativeQuery("UPDATE ca2.person SET ADDRESS_ID=" + p.getAddress().getId() + " WHERE ID=" + p.getId());
                p = person;
                p.getAddress().setCityInfo(null);
                em.merge(p);
//                query2.executeUpdate();
            }
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    public List<CityInfo> getAllZipCodes()
    {
        EntityManager em = getEntityManager();

        List<CityInfo> ciList = null;

        try
        {
            em.getTransaction().begin();
            ciList = em.createQuery("SELECT NEW DTO.CityInfoDTO(p) from CityInfo p", CityInfo.class).getResultList();

            em.getTransaction().commit();
            return ciList;
        } finally
        {
            em.close();
        }
    }
//    public PersonDTO deletePerson(long id)
//    {
//        EntityManager em = getEntityManager();
//        
//        PersonDTO p = null;
//
//        try
//        {
//            em.getTransaction().begin();
//            TypedQuery<PersonDTO> query = em.createQuery("select p from Person p where p.id = :id", PersonDTO.class);
//            query.setParameter("id", id);
//            p = query.getSingleResult();
//            if (p != null)
//            {
//                em.remove(p);
//            }
//            em.getTransaction().commit();
//            return p;
//        } finally
//        {
//            em.close();
//        }
//    }
//    
//    public Person deletePerson(long id)
//    {
//        EntityManager em = emf.createEntityManager();
//
//        try
//        {
//            em.getTransaction().begin();
//            Query query = em.createQuery("select p from Person p where p.id = :id", Person.class);
//            Query query2 = em.createQuery("select p from Address p where p.id = :id", Person.class);
//            Query query3 = em.createQuery("select p from Person p where p.id = :id", Person.class);
//            query.setParameter("id", id);
//            Person p = (Person) query.getSingleResult();
//            
//            if (p != null)
//            {
//                em.remove(p);
//            }
//            em.getTransaction().commit();
//            return p;
//        } finally
//        {
//            em.close();
//        }
//    }

    public List<PersonDTO> getPersonsInCity(String zip){
          EntityManager em = getEntityManager();
          

        try
        {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("select new DTO.ContactInfo(p) From Person p join p.address pa join pa.cityInfo pac where pac.zip = :zip", PersonDTO.class);
            query.setParameter("zip", zip);
           em.getTransaction().commit();
                return query.getResultList();
       }finally{
           em.close();
        }
        
    }
}
