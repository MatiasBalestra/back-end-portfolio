package com.example.demo.ServiceImplementacion;

import com.example.demo.Entity.Education;
import com.example.demo.Entity.Skills;

import java.util.List;
import java.util.Optional;

public interface IEducationService {


    public List<Education> listEducation();
    public Optional<Education> getOne(Long id);
    public void saveEducation(Education education);
    public void deleteEducation(Long id);
    public boolean existEducationById(Long id);
}
