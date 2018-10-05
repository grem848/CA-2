package DTO;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonDTO
{

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
    public int hashCode()
    {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.addressStreet);
        hash = 97 * hash + Objects.hashCode(this.addressAddInfo);
        hash = 97 * hash + Objects.hashCode(this.cityInfoCity);
        hash = 97 * hash + Objects.hashCode(this.cityInfoZip);
        hash = 97 * hash + Objects.hashCode(this.phones);
        hash = 97 * hash + Objects.hashCode(this.hobbies);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final PersonDTO other = (PersonDTO) obj;
        if (!Objects.equals(this.email, other.email))
        {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName))
        {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName))
        {
            return false;
        }
        if (!Objects.equals(this.addressStreet, other.addressStreet))
        {
            return false;
        }
        if (!Objects.equals(this.addressAddInfo, other.addressAddInfo))
        {
            return false;
        }
        if (!Objects.equals(this.cityInfoCity, other.cityInfoCity))
        {
            return false;
        }
        if (!Objects.equals(this.cityInfoZip, other.cityInfoZip))
        {
            return false;
        }
        if (!Objects.equals(this.address, other.address))
        {
            return false;
        }
        if (!Objects.equals(this.phones, other.phones))
        {
            return false;
        }
        if (!Objects.equals(this.hobbies, other.hobbies))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "PersonDTO{" + "email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", addressStreet=" + addressStreet + ", addressAddInfo=" + addressAddInfo + ", cityInfoCity=" + cityInfoCity + ", cityInfoZip=" + cityInfoZip + '}';
    }


}
