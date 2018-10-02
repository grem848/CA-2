
package DTO;

import entity.CityInfo;
import entity.Person;
import java.util.Collection;


public class AddressDTO {
    
    private Long id;
    private String street;
    private String additionalInfo;
    private Collection<Person> persons;
    private CityInfo cityInfo;

    public AddressDTO()
    {
    }
    
    public AddressDTO(Long id, String street, String additionalInfo, Collection<Person> persons, CityInfo cityInfo) {
        this.id = id;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.persons = persons;
        this.cityInfo = cityInfo;
    }
    
    public String getCityInfoCity()
    {
        return cityInfo.getCity();
    }
    
    public String getCityInfoZip()
    {
        return cityInfo.getZip();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }
    
}
