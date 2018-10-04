package DTO;

import entity.CityInfo;

public class CityInfoDTO
{

    private Long id;
    private String zip;
    private String city;

    public CityInfoDTO()
    {
    }

    public CityInfoDTO(CityInfo cityInfo)
    {
        this.zip = cityInfo.getZip();
        this.city = cityInfo.getCity();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
        return "CityInfoDTO{" + "id=" + id + ", zip=" + zip + ", city=" + city + '}';
    }

    
}
