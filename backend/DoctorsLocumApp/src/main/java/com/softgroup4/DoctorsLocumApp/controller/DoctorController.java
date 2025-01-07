package com.softgroup4.DoctorsLocumApp.controller;

import com.softgroup4.DoctorsLocumApp.entity.Doctor;
import com.softgroup4.DoctorsLocumApp.entity.LocumDoctor;
import com.softgroup4.DoctorsLocumApp.repository.DoctorRepository;
import com.softgroup4.DoctorsLocumApp.service.DoctorService;
import com.softgroup4.DoctorsLocumApp.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
    private DoctorRepository doctorRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

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

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createDoctor(@RequestBody Map<String, Object> doctorRequest) {
        String type = (String) doctorRequest.get("type");
        Doctor doctor;

        if ("LocumDoctor".equalsIgnoreCase(type)){
            LocumDoctor locumDoctor = new LocumDoctor();
            locumDoctor.setAvailable((Boolean) doctorRequest.get("isAvailable"));
            locumDoctor.setHourlyRate((Double) doctorRequest.get("hourlyRate"));
            doctor = locumDoctor;
        } else{
            doctor = new Doctor();
        }

        doctor.setFastName((String) doctorRequest.get("fastName"));
        doctor.setLastName((String) doctorRequest.get("lastName"));
        doctor.setEmail((String) doctorRequest.get("email"));
        doctor.setPhoneNumber((String) doctorRequest.get("phoneNumber"));
        doctor.setSpecialization((String) doctorRequest.get("specialization"));
        doctor.setLicenseNumber((String) doctorRequest.get("licenseNumber"));
        doctor.setDateOfBirth(LocalDate.parse((String) doctorRequest.get("dateOfBirth")));
        doctor.setYearsOfExperience((Integer) doctorRequest.get("yearsOfExperience"));
        doctor.setUsername((String) doctorRequest.get("username"));
        doctor.setPassword(passwordEncoder.encode((String) doctorRequest.get("password")));
        doctor.setRoles(Set.of((String) doctorRequest.get("role")));

        Doctor savedDoctor = doctorRepository.save(doctor);

        Map<String, Object> response = getResponse(savedDoctor);

        return ResponseEntity.ok(response);
    }

    // Response after instance of Doctor is saved.
    private static Map<String, Object> getResponse(Doctor savedDoctor) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Doctor created successfully");
        response.put("doctorId", savedDoctor.getId());
        response.put("username", savedDoctor.getUsername());
        response.put("email", savedDoctor.getEmail());
        if (savedDoctor instanceof LocumDoctor) {
            response.put("isAvailable", ((LocumDoctor) savedDoctor).isAvailable());
            response.put("hourlyRate", ((LocumDoctor) savedDoctor).getHourlyRate());
        }
        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        if(!doctorRepository.existsById(id)){
            return ResponseEntity.status(404).body("Doctor with that ID not found");
        }
        doctorService.delete(id);
        return ResponseEntity.ok("Doctor with Id " + id + " deleted successfully.");
    }
}
