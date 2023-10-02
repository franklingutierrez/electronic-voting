package com.cavm.elecciones.escolares.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavm.elecciones.escolares.models.Grade;
import com.cavm.elecciones.escolares.services.IGradeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private IGradeService gradeService;
	
	
	@GetMapping("")
	public String grade(Model model) {
		Grade nuevoGrade = new Grade();
		model.addAttribute("ruta", "grade");
		model.addAttribute("title", "Grado");
		model.addAttribute("grades", gradeService.findAll());
		model.addAttribute("nuevoGrade", nuevoGrade);
		return "grade";
	}
	
	@PostMapping("")
	public String grade(@Valid Grade nuevoGrade, BindingResult result) {
		if(!result.hasErrors()) {
			gradeService.save(nuevoGrade);
		}
		return "redirect:/grade";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		if(id >0) {
			gradeService.deleteById(id);
		}
		return "redirect:/grade";
	}
	
}
