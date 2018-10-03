/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohammahomarhariri
 */
public class ContactInfo {
    
    private Long id;
    private String name;
    private String email;
    
    private List<PhoneDTO> phones = new ArrayList();

    public ContactInfo(Person p) {
        this.id = p.getId();
        this.name = p.getFirstName() + " " + p.getLastName();
        this.email = p.getEmail();
        
        for (Phone phone : p.getPhones()) {
            phones.add(new PhoneDTO(phone));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    @Override
    public String toString()
    {
        return "ContactInfo{" + "id=" + id + ", name=" + name + ", email=" + email + ", phones=" + phones + '}' + "\n";
    }
    
    
}
