package com.cavm.voto.electronico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cavm.voto.electronico.models.Section;
import com.cavm.voto.electronico.services.ISectionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/section")
public class SectionController {
	
	@Autowired
	private ISectionService SectionService;
	
	
	@GetMapping("")
	public String grade(Model model) {
		Section nuevoSection = new Section();
		model.addAttribute("ruta", "section");
		model.addAttribute("title", "Sección");
		model.addAttribute("sections", SectionService.findAllByOrderById());
		model.addAttribute("nuevoSection", nuevoSection);
		return "section";
	}
	
	@PostMapping("")
	public String grade(@Valid Section nuevoSection, BindingResult result, RedirectAttributes redirect) {
		if(!result.hasErrors()) {
			SectionService.save(nuevoSection);
			redirect.addFlashAttribute("message", new String[] {"OK", "Registro exitoso!!"});
		}else {
			redirect.addFlashAttribute("message", new String[] {"ERROR", "Ingrese todos los datos!!"});
		}
		return "redirect:/section";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id,RedirectAttributes redirect) {
		if(id >0) {
			SectionService.deleteById(id);
			redirect.addFlashAttribute("message", new String[] {"OK", "Registro eliminado!!"});
		}
		return "redirect:/section";
	}
	
}
