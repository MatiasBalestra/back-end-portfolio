package com.example.demo.Controllers;


import com.example.demo.Entity.Persona;
import com.example.demo.Entity.Skills;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.ServiceImplementacion.ISkillsService;
import com.example.demo.dto.mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin
public class SkillController {

    @Autowired
    private ISkillsService skillServ;

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/details")
    public List<Skills> getSkill(){
        return skillServ.listSkill();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{id}")
    public String createSkill (@RequestBody Skills habilidad,
                               @PathVariable Long id){
        Persona persona =personaRepository.getById(id);
        persona.getSkills().add(habilidad);

        skillServ.saveSkill(habilidad);
        return "Skill Creada Correctamente";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String eliminarSkill(@PathVariable Long id){
        skillServ.deleteSkill(id);
        return "Skill Eliminada Correctamente";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Skills habilidad){
        Skills dom_skill = skillServ.getOne(id).get();

        dom_skill.setNameSkill(habilidad.getNameSkill());
        dom_skill.setLevelSkill(habilidad.getLevelSkill());
        dom_skill.setLogoSkill(habilidad.getLogoSkill());

        skillServ.saveSkill(dom_skill);
        return new ResponseEntity(new mensaje("Skill Actualizada"), HttpStatus.OK);
    }
}