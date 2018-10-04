package facade;

import DTO.ContactInfo;
import DTO.PersonDTO;
import entity.CityInfo;
import entity.Person;
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

    public PersonDTO getPerson(long id)
    {
        EntityManager em = getEntityManager();

        PersonDTO p = null;

        try
        {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("Select new DTO.PersonDTO(p) from Person p where p.id = :id", PersonDTO.class);
            query.setParameter("id", id);
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

    public ContactInfo getPersonContactInfo(long id)
    {
        EntityManager em = getEntityManager();

        ContactInfo p = null;

        try
        {
            em.getTransaction().begin();
            TypedQuery<ContactInfo> query = em.createQuery("Select new DTO.ContactInfo(p) from Person p where p.id = :id", ContactInfo.class);
            query.setParameter("id", id);
            p = query.getSingleResult();
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    public Person addPerson(Person p)
    {
        EntityManager em = getEntityManager();

        CityInfo cityInfo = null;
        try
        {
            CityInfo cityInfo2 = p.getAddress().getCityInfo();
            p.getAddress().setCityInfo(null);

            em.getTransaction().begin();
            em.persist(p);

            Query query = em.createQuery("select p from CityInfo p where p.zip = :zip", CityInfo.class);
            query.setParameter("zip", cityInfo2.getZip());
            cityInfo = (CityInfo) query.getSingleResult();

            Query query2 = em.createNativeQuery("UPDATE ca2.address SET CITYINFO_ID= " + cityInfo.getId() + " WHERE ID=" + p.getAddress().getId());
            query2.executeUpdate();

            List<Phone> plist = p.getPhones();
            for (Phone phone : plist)
            {
                Query query3 = em.createNativeQuery("UPDATE ca2.phone SET PERSON_ID=" + p.getId() + " WHERE ID=" + phone.getId());
                query3.executeUpdate();

            }

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
            Query query = em.createQuery("select p from Person p where p.id = :id", Person.class);
            query.setParameter("id", person.getId());
            Person p = (Person) query.getSingleResult();
            if (p != null)
            {
                Query query2 = em.createNativeQuery("UPDATE ca2.person SET ADDRESS_ID=" + p.getAddress().getId() + " WHERE ID=" + p.getId());
                p = person;
                p.getAddress().setCityInfo(null);
                em.merge(p);
                query2.executeUpdate();
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
}
