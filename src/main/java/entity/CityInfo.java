
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class CityInfo implements Serializable {

    @Id
    private String zip;
    
    private String city;
    
    @OneToMany(mappedBy = "cityInfo", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public CityInfo(String zip, String city)
    {
        this.zip = zip;
        this.city = city;
    }

    public CityInfo() {
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "CityInfo{" + "zip=" + zip + ", city=" + city + "}";
    }
    
    
}
