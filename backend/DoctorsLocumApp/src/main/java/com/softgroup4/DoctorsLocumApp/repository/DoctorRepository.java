package com.softgroup4.DoctorsLocumApp.repository;

import com.softgroup4.DoctorsLocumApp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
Optional<Doctor> findByUsername(String username);
}
