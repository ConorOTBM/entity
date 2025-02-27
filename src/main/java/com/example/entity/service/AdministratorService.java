package com.example.entity.service;

import com.example.entity.model.Administrator;
import com.example.entity.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Optional<Administrator> getAdministratorById(Long id) {
        return administratorRepository.findById(id);
    }

    public void deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);
    }

    public Administrator updateAdministrator(Long id, Administrator administratorDetails) {
        Administrator administrator = administratorRepository.findById(id).orElseThrow();
        administrator.setFirstname(administratorDetails.getFirstname());
        administrator.setLastname(administratorDetails.getLastname());
        administrator.setEmail(administratorDetails.getEmail());
        administrator.setStaffnumber(administratorDetails.getStaffnumber());
        administrator.setLead(administratorDetails.getLead());
        return administratorRepository.save(administrator);
    }
}
