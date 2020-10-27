package org.nidhee.java2blog.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="address")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "city")
    String city;

    @Column(name = "country")
    String country;

    @Column(name = "zipcode")
    String zipcode;


    public Address(){
        super();
    }
    public Address(String city, String country, String zipcode) {
        super();
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
