package com.example.demo.Controllers;


import com.example.demo.Entity.Education;
import com.example.demo.Entity.Persona;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.ServiceImplementacion.IEducationService;
import com.example.demo.dto.mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
@CrossOrigin
public class EducationController {


    @Autowired
    private IEducationService educationServ;

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/details")
    public List<Education> getEducation(){
        return educationServ.listEducation();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{id}")
    public String createEducation (@RequestBody Education education,
                               @PathVariable Long id){
        Persona persona =personaRepository.getById(id);
        persona.getEducation().add(education);

        educationServ.saveEducation(education);
        return "Educacion Creada Correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
        public String eliminarSkill(@PathVariable Long id){
        educationServ.deleteEducation(id);
        return "Educacion Eliminada Correctamente";
     }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Education education){
        Education dom_education = educationServ.getOne(id).get();

        dom_education.setTitulo(education.getTitulo());
        dom_education.setInstitutoName(education.getInstitutoName());
        dom_education.setDescriptionEducation(education.getDescriptionEducation());
        dom_education.setLinkCertificado(education.getLinkCertificado());
        dom_education.setFecha_ini(education.getFecha_ini());
        dom_education.setFecha_fin(education.getFecha_fin());

        educationServ.saveEducation(dom_education);
        return new ResponseEntity(new mensaje("Educaction Actualizada"), HttpStatus.OK);
    }








}
