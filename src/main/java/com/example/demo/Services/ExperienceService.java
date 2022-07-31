package com.example.demo.Services;

import com.example.demo.Entity.Experience;
import com.example.demo.Repository.ExperienceRepository;
import com.example.demo.ServiceImplementacion.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    ExperienceRepository expeRepo;


    @Override
    public List<Experience> listExperience() {
        return expeRepo.findAll();
    }

    @Override
    public Optional<Experience> getOne(Long id) {
        return expeRepo.findById(id);
    }

    @Override
    public void saveExperience(Experience job) {
        expeRepo.save(job);

    }

    @Override
    public void deleteExperience(Long id) {
        expeRepo.deleteById(id);

    }

    @Override
    public boolean existExperienceById(Long id) {
        return expeRepo.existsById(id);
    }





}
