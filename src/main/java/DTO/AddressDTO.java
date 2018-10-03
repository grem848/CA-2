package DTO;

import entity.Address;
import entity.CityInfo;
import entity.Person;
import java.util.List;

public class AddressDTO
{

    private Long id;
    private String street;
    private String additionalInfo;
    private List<Person> persons;
    private CityInfo cityInfo;
    private String cityInfoCity;
    private String cityInfoZip;

    public AddressDTO()
    {
    }

    public AddressDTO(Address a)
    {
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalInfo();
        this.cityInfoCity = a.getCityInfo().getCity();
        this.cityInfoZip = a.getCityInfo().getZip();

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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
    }

    public List<Person> getPersons()
    {
        return persons;
    }

    public void setPersons(List<Person> persons)
    {
        this.persons = persons;
    }

    public CityInfo getCityInfo()
    {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo)
    {
        this.cityInfo = cityInfo;
    }

}
