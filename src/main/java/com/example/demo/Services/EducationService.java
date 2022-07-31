package com.example.demo.Services;


import com.example.demo.Entity.Education;
import com.example.demo.Repository.EducationRepository;
import com.example.demo.ServiceImplementacion.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService implements IEducationService {


    @Autowired
    private EducationRepository educationRepository;


    @Override
    public List<Education> listEducation() {
        return educationRepository.findAll();
    }


    @Override
    public Optional<Education> getOne(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
    }


    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public boolean existEducationById(Long id) {
        return educationRepository.existsById(id);
    }

}
