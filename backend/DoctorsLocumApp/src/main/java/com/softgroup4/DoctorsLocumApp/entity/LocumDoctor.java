package com.softgroup4.DoctorsLocumApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "locum_doctor")
public class LocumDoctor extends Doctor {
    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;
    @Column(name = "hourlyRate", nullable = false)
    private double hourlyRate;

    public LocumDoctor() {
        super();
    }

    public LocumDoctor(boolean isAvailable, double hourlyRate) {
        this.isAvailable = isAvailable;
        this.hourlyRate = hourlyRate;
    }

    public LocumDoctor(String fastName, String lastName, String email, String phoneNumber, String specialization, String licenseNumber, LocalDate dateOfBirth, int yearsOfExperience, String username, String password, Set<String> roles, Hospital hospital, boolean isAvailable, double hourlyRate) {
        super(fastName, lastName, email, phoneNumber, specialization, licenseNumber, dateOfBirth, yearsOfExperience, username, password, roles, hospital);
        this.isAvailable = isAvailable;
        this.hourlyRate = hourlyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = isAvailable;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "LocumDoctor{" + "hourlyRate=" + hourlyRate + ", isAvailable=" + isAvailable + "}" + super.toString();
    }
}
