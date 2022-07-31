package com.example.demo.Controllers;


import com.example.demo.Entity.Experience;
import com.example.demo.Entity.Persona;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.ServiceImplementacion.IExperienceService;
import com.example.demo.dto.mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin
public class ExperienceController {

    @Autowired
    private IExperienceService expeServ;

    @Autowired
    PersonaRepository personaRepository;


    @GetMapping("/details")
    public List<Experience> getExperience(){
        return expeServ.listExperience();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{id}")
    public String createExperience(@RequestBody Experience job,
                                   @PathVariable Long id){
        Persona persona = personaRepository.getById(id);
        persona.getExperiences().add(job);
        expeServ.saveExperience(job);
        return "Experience Creada Correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String eliminarExperience(@PathVariable Long id){
        expeServ.deleteExperience(id);
        return "Experience Eliminada Correctamente";

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Experience job){

        Experience dom_job = expeServ.getOne(id).get();

        dom_job.setJobPosition(job.getJobPosition());
        dom_job.setJobCompany(job.getJobCompany());
        dom_job.setJobDescription(job.getJobDescription());
        dom_job.setJobType(job.getJobType());
        dom_job.setJobLocalization(job.getJobLocalization());
        dom_job.setFecha_ini(job.getFecha_ini());
        dom_job.setFecha_fin(job.getFecha_fin());
        dom_job.setUrl_imgJob(job.getUrl_imgJob());

        expeServ.saveExperience(dom_job);
        return new ResponseEntity(new mensaje("Experience Actualizada"), HttpStatus.OK);
    }



}
