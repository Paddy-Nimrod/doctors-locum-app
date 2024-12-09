package com.softgroup4.DoctorsLocumApp.service;

import com.softgroup4.DoctorsLocumApp.entity.Doctor;
import com.softgroup4.DoctorsLocumApp.entity.LocumDoctor;
import com.softgroup4.DoctorsLocumApp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepository.save(doctor);
    }

    @Transactional
    public LocumDoctor saveLocumDoctor(LocumDoctor locumDoctor) {
        locumDoctor.setPassword(passwordEncoder.encode(locumDoctor.getPassword()));
        locumDoctor.getRoles().add("LOCUM_DOCTOR");
        return doctorRepository.save(locumDoctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor with that Id not found."));
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}

