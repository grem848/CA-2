
package DTO;

import entity.Phone;


public class PhoneDTO {
    
    private Long id;
    private String phone;
    private String description;

    public PhoneDTO(Phone p) {
        this.phone = p.getNumber();
        this.description = p.getDescription();
    }
    
    public PhoneDTO()
    {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
