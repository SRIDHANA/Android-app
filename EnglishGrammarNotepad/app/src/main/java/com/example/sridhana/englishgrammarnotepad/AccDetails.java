package com.example.sridhana.englishgrammarnotepad;

/**
 * Created by Sridhana on 3/17/2017.
 */

public class AccDetails {

    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String address1;

    public AccDetails()
    {
    }
    public AccDetails(int id,String name,String address)
    {
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public AccDetails(String name, String address) {
        this.name=name;
        this.address=address;
    }

    public AccDetails(Integer id,String name, String address, String email, String phone, String address1) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.phone=phone;
        this.address1=address1;

    }

    public AccDetails(String name, String address, String email, String phone, String address1) {
        this.name=name;
        this.address=address;
        this.email=email;
        this.phone=phone;
        this.address1=address1;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }

}
