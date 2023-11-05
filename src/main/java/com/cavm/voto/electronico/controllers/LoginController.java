package com.cavm.voto.electronico.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cavm.voto.electronico.models.ChangePasswordForm;
import com.cavm.voto.electronico.models.User;
import com.cavm.voto.electronico.respositories.IUserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping({"/login","/"})
	public String login(@RequestParam(value = "error", required = false)String error, Model model, Principal principal) {
		if(principal != null) {
			return "redirect:/institution";
		}
		if(error != null) {
			model.addAttribute("message", new String[] {"ERROR", "Nombre de usuario o contraseña incorrecta"});
		}
		return "login";
	}
	
	@GetMapping("change-password")
	public String changePassword(Model model) {
		ChangePasswordForm changePasswordForm = new ChangePasswordForm();
		model.addAttribute("title", "Cambiar Contraseña");
		model.addAttribute("changePasswordForm", changePasswordForm);
		return "change-password";
	}
	
	@PostMapping("change-password")
	public String changePassword(@Valid ChangePasswordForm changePasswordForm, 
									BindingResult result,
									Principal principal,
									Model model, 
									RedirectAttributes redirect,
									HttpServletRequest request) {
		model.addAttribute("title", "Cambiar Contraeña");
		if (result.hasErrors()) {
            return "change-password";
        }
		if(!changePasswordForm.getNewPassword().equals(changePasswordForm.getRepeatNewPassword())) {
			changePasswordForm.setNewPassword("");
			changePasswordForm.setRepeatNewPassword("");
			model.addAttribute("message", new String[] {"ERROR", "Las nuevas contraseñas no coinciden!!"});
			return "change-password";
		}
		User user = userRepository.findByUsername(principal.getName());
		if(user != null) {
			if(passwordEncoder.matches(changePasswordForm.getCurrentPassword(), user.getPassword())) {
				System.out.println("ingresamosss");
				String encodedNewPassword = passwordEncoder.encode(changePasswordForm.getNewPassword());
                user.setPassword(encodedNewPassword);
                userRepository.save(user); // Actualiza la contraseña en la base de datos
                System.out.println("terminamos");
                new SecurityContextLogoutHandler().logout(request, null, null);
                redirect.addFlashAttribute("message", new String[] {"OK", "Contraseña actualizada!!!"});
                return "redirect:/login?logout";
			}else {
				// si las contraseñas no coinciden
				changePasswordForm.setCurrentPassword("");
				model.addAttribute("message", new String[] {"ERROR", "Su contraseña actual es incorrecta!!!"});
				return "change-password";
			}
		}
		
		
		return "change-password";
	}

}
