package com.softgroup4.DoctorsLocumApp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hospitals")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name ="address", nullable = false, length = 255)
    private String address;

    @Column(name = "county", nullable = false, length = 50)
    private String county;

    @Column(name = "sub_county", nullable = false, length = 50)
    private String subCounty;

    @Column(name="zip_code", nullable=false, length = 10)
    private String zipCode;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "capacity", nullable = false)
    private String capacity;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Doctor> doctors;

    public Hospital() {
    }

    public Hospital(String name, String address, String county, String subCounty, String zipCode, String email, String capacity, List<Doctor> doctors) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.subCounty = subCounty;
        this.zipCode = zipCode;
        this.email = email;
        this.capacity = capacity;
        this.doctors = doctors;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSubCounty() {
        return subCounty;
    }

    public void setSubCounty(String subCounty) {
        this.subCounty = subCounty;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
