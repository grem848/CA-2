package facade;

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
    
    public PersonDTO getPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();

        PersonDTO p = null;
        
        try
        {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("Select new entity.PersonDTO(p.firstName, p.lastName, p.phoneNumber) from Person p where p.firstName = :firstName and p.lastName = :lastName", PersonDTO.class);
            query.setParameter("firstName", person.getFirstName());
            query.setParameter("lastName", person.getLastName());
            if(query.getResultList().size() > 0)
            {
                p = query.getResultList().get(0);
            }
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }    
    }
    
    public List<PersonDTO> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        List<PersonDTO> persons = null;
        
        try
        {
            em.getTransaction().begin();
//            persons = em.createQuery("Select p from Person p").getResultList();
            //TypedQuery<PersonDTO> qt = em.createQuery("SELECT NEW entity.PersonDTO(p.firstName, p.lastName, p.phoneNumber) from Person p", PersonDTO.class);
            //persons = qt.getResultList();
            persons = em.createQuery("SELECT NEW entity.PersonDTO(p.firstName, p.lastName, p.phoneNumber) from Person p", PersonDTO.class).getResultList();
                    
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }

    public Person addPerson(Person p)
    {
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    public Person deletePerson(Person person)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Person p where p.id = :id", Person.class);
            query.setParameter("id", person.getId());
            Person p = (Person) query.getSingleResult();
            if(p != null)
            {
                em.remove(p);                
            }
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    public Person editPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Query query = em.createQuery("select p from Person p where p.id = :id", Person.class);
            query.setParameter("id", person.getId());
            Person p = (Person) query.getSingleResult();
            if(p != null)
            {
                p = person;
                em.merge(p);
            }
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }  
    }
}