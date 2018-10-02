/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entity.Address;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 *
 * @author mohammahomarhariri
 */
public class CityInfoDTO {
    
    private Long id;
    private String zip;
    private String city;
    private Collection<Address> addresses;

    public CityInfoDTO(Long id, String zip, String city, Collection<Address> addresses) {
        this.id = id;
        this.zip = zip;
        this.city = city;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
    
    
    
}
