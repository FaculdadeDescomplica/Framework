package com.descomplica.FrameBlog.models.v2;

import jakarta.persistence.*;

@Entity
@Table(name = "Address")
public class AddressV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserV2 userV2;

    public AddressV2() {
    }

    public AddressV2(Long addressId, String street, String city, String state, String zipCode, String country, UserV2 userV2) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.userV2 = userV2;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserV2 getUserV2() {
        return userV2;
    }

    public void setUserV2(UserV2 userV2) {
        this.userV2 = userV2;
    }

    public void setUser(UserV2 userV2) {
    }

    public UserV2 getUser() {
        return this.userV2;
    }
}
