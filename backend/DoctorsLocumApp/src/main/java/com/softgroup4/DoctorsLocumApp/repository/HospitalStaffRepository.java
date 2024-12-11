package com.softgroup4.DoctorsLocumApp.repository;

import com.softgroup4.DoctorsLocumApp.entity.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalStaffRepository extends JpaRepository<HospitalStaff,Long> {
    Optional<HospitalStaff> findByUsername(String username);
}
