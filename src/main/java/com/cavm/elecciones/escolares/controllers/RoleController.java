package com.cavm.elecciones.escolares.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cavm.elecciones.escolares.models.Role;
import com.cavm.elecciones.escolares.services.IRoleService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@GetMapping
	public String role(Model model) {
		Role nuevoRol = new Role();
		model.addAttribute("ruta", "role");
		model.addAttribute("title", "Roles");
		model.addAttribute("roles", roleService.findAllByOrderByOrder());
		model.addAttribute("nuevoRol", nuevoRol);
		return "role";
		
	}
	
	@PostMapping
	public String role(@Valid Role role, BindingResult result ) {
		if(!result.hasErrors()) {
			roleService.save(role);
		}
		return "redirect:/role";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		if(id>0) {
			roleService.deleteById(id);
		}
		return "redirect:/role";
		
	}

}
