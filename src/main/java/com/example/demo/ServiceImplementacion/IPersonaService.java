package com.example.demo.ServiceImplementacion;


import com.example.demo.Entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public List<Persona> listPersona();
    public Optional<Persona> getOne(Long id);
    public void savePersona(Persona persona);
    public void deletePersona(Long id);
    public boolean existPersonaById(Long id);





}
