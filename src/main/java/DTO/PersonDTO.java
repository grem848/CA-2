package DTO;

import entity.Address;
import entity.Hobby;
import entity.Phone;
import java.util.List;

public class PersonDTO
{

    private Long id;

    private String email;
    private String firstName;
    private String lastName;

    private Address address;
    private String addressStreet;
    private String addressAddInfo;
    private String cityInfoCity;
    private String cityInfoZip;

    private List<Phone> phones;

    private List<Hobby> hobbies;

    public PersonDTO()
    {
    }

    public PersonDTO(String email, String firstName, String lastName)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDTO(Long id, String email, String firstName, String lastName, String addressStreet, String addressAddInfo, String cityInfoCity, String cityInfoZip)
    {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressStreet = addressStreet;
        this.addressAddInfo = addressAddInfo;
        this.cityInfoCity = cityInfoCity;
        this.cityInfoZip = cityInfoZip;
    }
    
    public PersonDTO(Long id, String email, String firstName, String lastName, String addressStreet, String addressAddInfo)
    {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressStreet = addressStreet;
        this.addressAddInfo = addressAddInfo;
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

    public String getCityInfoCity()
    {
        return cityInfoCity;
    }

    public void setCityInfoCity(String cityInfoCity)
    {
        this.cityInfoCity = cityInfoCity;
    }

    public String getCityInfoZip()
    {
        return cityInfoZip;
    }

    public void setCityInfoZip(String cityInfoZip)
    {
        this.cityInfoZip = cityInfoZip;
    }
    
    public String getAddressStreet()
    {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet)
    {
        this.addressStreet = addressStreet;
    }

    public String getAddressAddInfo()
    {
        return addressAddInfo;
    }

    public void setAddressAddInfo(String addressAddInfo)
    {
        this.addressAddInfo = addressAddInfo;
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones(List<Phone> phones)
    {
        this.phones = phones;
    }

    public List<Hobby> getHobbies()
    {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies)
    {
        this.hobbies = hobbies;
    }

    @Override
    public String toString()
    {
        return "PersonDTO{" + "id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", addressStreet=" + addressStreet + ", addressAddInfo=" + addressAddInfo + ", cityInfoCity=" + cityInfoCity + ", cityInfoZip=" + cityInfoZip + ", phones=" + phones + ", hobbies=" + hobbies + '}' + "\n";
    }




}
