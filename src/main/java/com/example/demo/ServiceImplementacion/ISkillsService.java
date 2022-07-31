package com.example.demo.ServiceImplementacion;

import com.example.demo.Entity.Skills;

import java.util.List;
import java.util.Optional;

public interface ISkillsService {
    public List<Skills> listSkill();
    public Optional<Skills> getOne(Long id);
    public void saveSkill(Skills skill);
    public void deleteSkill(Long id);
    public boolean existSkillById(Long id);
}
