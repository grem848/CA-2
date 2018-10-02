package facade;

import DTO.PersonDTO;
import entity.Person;
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

    public PersonDTO getPerson(Person person)
    {
        EntityManager em = getEntityManager();

        PersonDTO p = null;

        try
        {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("Select new DTO.PersonDTO(p.id, p.email, p.firstName, p.lastName, p.address) from Person p where p.id = :id", PersonDTO.class);
            query.setParameter("id", person.getId());
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
            persons = em.createQuery("SELECT NEW DTO.PersonDTO(p.id, p.email, p.firstName, p.lastName, p.address) from Person p", PersonDTO.class).getResultList();
//            persons = em.createQuery("SELECT NEW DTO.PersonDTO(p.id, p.email, p.firstName, p.lastName, p.address, p.address.street, p.address.additionalInfo) from Person p", PersonDTO.class).getResultList();

            em.getTransaction().commit();
            return persons;
        } finally
        {
            em.close();
        }
    }

    public List<PersonDTO> getAllPersonsContactInfo()
    {
        EntityManager em = getEntityManager();

        List<PersonDTO> persons = null;

        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("SELECT NEW DTO.PersonDTO(p.id, p.email, p.firstName, p.lastName, p.address) from Person p", PersonDTO.class).getResultList();

            em.getTransaction().commit();
            return persons;
        } finally
        {
            em.close();
        }
    }

    public Person addPerson(Person p)
    {
        EntityManager em = getEntityManager();

        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

//    public PersonDTO deletePerson(Person person)
//    {
//        EntityManager em = getEntityManager();
//        
//        PersonDTO p = null;
//
//        try
//        {
//            em.getTransaction().begin();
//            TypedQuery<PersonDTO> query = em.createQuery("select p from Person p where p.id = :id", PersonDTO.class);
//            query.setParameter("id", person.getId());
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
    
//    public Person deletePerson(Person person)
//    {
//        EntityManager em = emf.createEntityManager();
//
//        try
//        {
//            em.getTransaction().begin();
//            Query query = em.createQuery("select p from Person p where p.id = :id", Person.class);
//            query.setParameter("id", person.getId());
//            Person p = (Person) query.getSingleResult();
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
                p = person;
                em.merge(p);
            }
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }
}
