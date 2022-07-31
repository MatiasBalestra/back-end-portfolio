package com.example.demo.Services;


import com.example.demo.Entity.Skills;
import com.example.demo.Repository.SkillsRepository;
import com.example.demo.ServiceImplementacion.ISkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService implements ISkillsService {


    @Autowired
    SkillsRepository skillsRepository;


    @Override
    public List<Skills> listSkill() {
        return skillsRepository.findAll();
    }

    @Override
    public Optional<Skills> getOne(Long id) {
        return skillsRepository.findById(id);
    }

    @Override
    public void saveSkill(Skills skill) {
        skillsRepository.save(skill);

    }

    @Override
    public void deleteSkill(Long id) {
        skillsRepository.deleteById(id);

    }

    @Override
    public boolean existSkillById(Long id) {
        return skillsRepository.existsById(id);
    }
}
