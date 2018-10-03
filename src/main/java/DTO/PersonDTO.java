package DTO;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO
{

    private Long id;

    private String email;
    private String firstName;
    private String lastName;

    private AddressDTO address;
    private String addressStreet;
    private String addressAddInfo;
    private String cityInfoCity;
    private String cityInfoZip;

    private List<PhoneDTO> phones = new ArrayList();

    private List<Hobby> hobbies;

    public PersonDTO()
    {
    }

    public PersonDTO(Person p)
    {
        this.id = p.getId();
        this.email = p.getEmail();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.address = (new AddressDTO (p.getAddress()));
        for (Phone phone : p.getPhones())
        {
            phones.add(new PhoneDTO(phone));
        }
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

    public AddressDTO getAddress()
    {
        return address;
    }

    public void setAddress(AddressDTO address)
    {
        this.address = address;
    }

    public List<PhoneDTO> getPhones()
    {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones)
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
