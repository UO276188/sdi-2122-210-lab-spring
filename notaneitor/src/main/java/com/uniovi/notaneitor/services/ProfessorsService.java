package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.repositories.ProfessorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {

    @Autowired
    private ProfessorsRepository professorsRepository;

    @PostConstruct
    public void init(){
        professorsRepository.save(new Professor(1L, "1M", "Sara", "Ramirez", "Music"));
        professorsRepository.save(new Professor(2L, "2M", "Celia", "Suarez", "Art"));
        professorsRepository.save(new Professor(3L, "4M", "Paco", "Paco", "Asociado"));
    }

    public List<Professor> getProfessors(){
        List<Professor> professors = new ArrayList<>();
        professorsRepository.findAll().forEach(professors::add);
        return professors;
    }

    public Professor getProfessor(Long id){
        return professorsRepository.findById(id).get();
    }

    public void addProfessor(Professor professor){
        professorsRepository.save(professor);
    }

    public void deleteProfessor(Long id){
        professorsRepository.deleteById(id);
    }
}
