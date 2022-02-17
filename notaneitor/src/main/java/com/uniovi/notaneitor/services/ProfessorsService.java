package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorsService {
    private List<Professor> professorsList = new LinkedList<>();

    @PostConstruct
    public void init(){
        professorsList.add(new Professor(1L, "1M", "Sara", "Ramirez", "Music"));
        professorsList.add(new Professor(2L, "2M", "Celia", "Suarez", "Art"));
        professorsList.add(new Professor(3L, "4M", "Paco", "Paco", "Asociado"));
    }

    public List<Professor> getProfessors(){
        return professorsList;
    }

    public Professor getProfessor(Long id){
        return professorsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addProfessor(Professor professor){
        if (professor.getId() == null){
            professor.setId(professorsList.get(professorsList.size() -1).getId()+1);
        }
        professorsList.add(professor);
    }

    public void deleteProfessor(Long id){
        professorsList.removeIf(t -> t.getId().equals(id));
    }
}
