package com.example.demo.Services;


import com.example.demo.Entity.Persona;
import com.example.demo.Repository.PersonaRepository;
import com.example.demo.ServiceImplementacion.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository RepositoryPersona;


    @Override
    public List<Persona> listPersona() {
        return RepositoryPersona.findAll();
    }

    @Override
    public Optional<Persona> getOne(Long id) {
        return RepositoryPersona.findById(id);
    }

    @Override
    public void savePersona(Persona persona) {
        RepositoryPersona.save(persona);

    }

    @Override
    public void deletePersona(Long id) {
        RepositoryPersona.deleteById(id);

    }

    @Override
    public boolean existPersonaById(Long id) {
        return RepositoryPersona.existsById(id);
    }
}
