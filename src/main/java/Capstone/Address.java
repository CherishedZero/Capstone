package Capstone;

public class Address {
    private int unit;
    private String street;
    private String city;
    private String province;
    private String zip;

    public Address(int unit, String street, String city, String province, String zip) {
        this.unit = unit;
        this.street = street;
        this.city = city;
        this.province = province;
        this.zip = zip;
    }

    public String toString() {
        return unit + " " + street + "\n" + city + ", " + province + " " + zip;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
