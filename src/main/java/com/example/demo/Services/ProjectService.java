package com.example.demo.Services;

import com.example.demo.Entity.Project;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.ServiceImplementacion.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectService implements IProjectService {

    @Autowired
    ProjectRepository projectRepo;


    @Override
    public List<Project> listProject() {
        return projectRepo.findAll();
    }

    @Override
    public Optional<Project> getOne(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public void saveProject(Project proyecto) {
        projectRepo.save(proyecto);

    }

    @Override
    public void deleteProject(Long id) {
        projectRepo.deleteById(id);

    }

    @Override
    public boolean existProjectById(Long id) {
        return projectRepo.existsById(id);
    }

}
