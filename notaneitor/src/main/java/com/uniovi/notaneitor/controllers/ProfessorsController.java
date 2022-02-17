package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorsController {
    @Autowired
    private ProfessorsService professorsService;

    @RequestMapping("/professor/add")
    public String setProfessor(){
        return "Formulario para añadir profesor.";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail(@PathVariable Long id){
        return "Details " + professorsService.getProffesor(id).toString();
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id){
        professorsService.deleteProfessor(id);
        return "Deleted " + id;
    }

    @RequestMapping("/professor/edit/{id}")
    public String edit(@PathVariable Long id){
        return "Editing " + professorsService.getProffesor(id);
    }
}
