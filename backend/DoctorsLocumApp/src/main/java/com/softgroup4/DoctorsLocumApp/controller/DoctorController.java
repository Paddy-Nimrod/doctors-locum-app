package com.softgroup4.DoctorsLocumApp.controller;

import com.softgroup4.DoctorsLocumApp.entity.Doctor;
import com.softgroup4.DoctorsLocumApp.entity.LocumDoctor;
import com.softgroup4.DoctorsLocumApp.service.DoctorService;
import com.softgroup4.DoctorsLocumApp.service.DoctorUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    public DoctorService doctorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DoctorUserDetailsService doctorUserDetailsService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful.");
            response.put("username", username);
            response.put("roles", authentication.getAuthorities());
            response.put("redirectUrl","/api/doctors/dashboard");
            return response;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username of password");
        }
    }

    @GetMapping("/dashboard")
    public Map<String, String> getDashboard(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to your account.");
        response.put("user", authentication.getName());
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(createdDoctor);
    }

    public ResponseEntity<LocumDoctor> createLocumDoctor(@RequestBody LocumDoctor locumDoctor) {
        LocumDoctor createdLocumDoctor = doctorService.saveLocumDoctor(locumDoctor);
        return ResponseEntity.ok(createdLocumDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
