package DTO;

import entity.CityInfo;

public class CityInfoDTO
{

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
        return "CityInfoDTO{" + "zip=" + zip + ", city=" + city + '}';
    }

    
}
