
package DTO;

import entity.Address;
import entity.Hobby;
import entity.Phone;
import java.util.Collection;


public class PersonDTO {
    
    private Long id;
    
    private String email;
    private String firstName;
    private String lastName;
    
    private Address address;
    
    private Collection<Phone> phones;
    
    private Collection<Hobby> hobbies;

    public PersonDTO()
    {
    }

    public PersonDTO(Long id, String email, String firstName, String lastName, Address address)
    {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public PersonDTO(String email, String firstName, String lastName, Address address)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public PersonDTO(Long id, String email, String firstName, String lastName, Address address, Collection<Phone> phones, Collection<Hobby> hobbies) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phones = phones;
        this.hobbies = hobbies;
    }

    public PersonDTO(String email, String firstName, String lastName, Address address, Collection<Phone> phones, Collection<Hobby> hobbies) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phones = phones;
        this.hobbies = hobbies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }

    public Collection<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Collection<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString()
    {
        return "PersonDTO{" + "id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phones=" + phones + ", hobbies=" + hobbies + '}' + "\n";
    }
    

}
