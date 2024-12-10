package com.softgroup4.DoctorsLocumApp.service;

import com.softgroup4.DoctorsLocumApp.entity.Doctor;
import com.softgroup4.DoctorsLocumApp.repository.DoctorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DoctorUserDetailsService implements UserDetailsService {
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Doctor with that username does not exist."));

        return User.builder()
                .username(doctor.getUsername())
                .password(doctor.getPassword())
                .roles(doctor.getRoles().toArray(new String[0]))
                .build();

    }
}
