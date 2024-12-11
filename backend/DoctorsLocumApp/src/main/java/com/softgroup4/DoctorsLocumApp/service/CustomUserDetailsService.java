package com.softgroup4.DoctorsLocumApp.service;

import com.softgroup4.DoctorsLocumApp.entity.Doctor;
import com.softgroup4.DoctorsLocumApp.entity.HospitalStaff;
import com.softgroup4.DoctorsLocumApp.repository.DoctorRepository;
import com.softgroup4.DoctorsLocumApp.repository.HospitalStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private HospitalStaffRepository hospitalStaffRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByUsername(username).orElse(null);

        if (doctor != null) {
            return new org.springframework.security.core.userdetails.User(
                    doctor.getUsername(),
                    doctor.getPassword(),
                    doctor.getRoles().stream().map(SimpleGrantedAuthority::new).toList()
            );
        }

        HospitalStaff hospitalStaff = hospitalStaffRepository.findByUsername(username).orElse(null);
        if (hospitalStaff != null) {
            return new org.springframework.security.core.userdetails.User(
                    hospitalStaff.getUsername(),
                    hospitalStaff.getPassword(),
                    hospitalStaff.getRoles().stream().map(SimpleGrantedAuthority::new).toList()
            );
        }
        throw new UsernameNotFoundException("Username not found.");


    }
}
