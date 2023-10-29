package com.cavm.elecciones.escolares.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cavm.elecciones.escolares.models.User;
import com.cavm.elecciones.escolares.services.IUserService;

@Controller
//@RequestMapping("/")
public class IndexController {
	@Autowired
	private IUserService userService;
	
	/*@GetMapping({"/"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring");
		return "redirect:/sign-in";
	}*/
	
	@GetMapping({"/menu"})
	public String menu(Model model) {
		model.addAttribute("titulo", "Hola Spring");
		return "index";
	}
	
	@GetMapping("/sign-in")
	public String signIn() {
		return "sign-in";
	}
	
	@PostMapping("/sign-in")
	public String signIn( @RequestParam String email, 
							@RequestParam String password, Model model) {
		
		if(email.isBlank() || password.isBlank()) {
			model.addAttribute("password", password);
			model.addAttribute("email", email);
			return "sign-in";
			
		}else {
			User usuario = userService.validarUser(email, password);
			/*User usu = new User();
			Calendar calendar = Calendar.getInstance();
			usu.setLast_name("Lopez Leyva");
			usu.setName("Alexander");
			usu.setPassword("12345678");
			usu.setUsername("alexlo@gmail.com");
			usu.setCreatedAt(calendar.getTime());
			usu.setUpdateAt(calendar.getTime());
			userService.save(usu);*/
			if(usuario == null) {
				model.addAttribute("message", "Credenciales incorectas!");
				return "sign-in";
			}
		}
		//model.addAttribute("title", "Grde");
		return "redirect:/grade";
	}
}
