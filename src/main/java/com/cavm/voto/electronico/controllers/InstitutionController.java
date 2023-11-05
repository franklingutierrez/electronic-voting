package com.cavm.voto.electronico.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cavm.voto.electronico.models.Institution;
import com.cavm.voto.electronico.services.IInstitutionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/institution")
public class InstitutionController {
	
	@Autowired
	private IInstitutionService institutionService;
	
	@GetMapping("")
	public String index(Model model) {
		Institution institution = institutionService.findFirstByOrderByIdAsc();
		if(institution==null)institution = new Institution();
		model.addAttribute("ruta", "institution");
		model.addAttribute("title", "Datos de la Institución");
		model.addAttribute("institution", institution);
		model.addAttribute("institution", institution);
		return "institution";
	}
	
	@PostMapping("")
	public String index(@Valid Institution inst, BindingResult result, @RequestParam MultipartFile logo, RedirectAttributes redirect) throws IOException, URISyntaxException {
		if(!inst.getName().isBlank()/* && !logo.isEmpty()*/) {
			Path directorioRecursos = null;
			if(!logo.isEmpty()) {
				directorioRecursos = Paths.get("src//main//resources//static/uploads");
				String rootPath 	= directorioRecursos.toFile().getAbsolutePath();
				Path path = Paths.get(rootPath);
				if(Files.exists(path)) {
					path	= Paths.get(rootPath, logo.getOriginalFilename());
				}else {
					path	= Paths.get(getClass().getResource("/static/uploads").toString().substring(6), logo.getOriginalFilename());
				}
				byte[] bytes 		= logo.getBytes();
				Files.write(path, bytes);
				inst.setLogo(logo.getOriginalFilename());
			}else {
				if(inst.getId()!=null) {
					Institution institucion = institutionService.findById(inst.getId());
					inst.setLogo(institucion.getLogo());
					redirect.addFlashAttribute("message", new String[] {"OK", "Actualizado con éxito!!!"});
					institutionService.save(inst);
					return "redirect:/institution";
				}else {
					redirect.addFlashAttribute("message", new String[] {"ERROR", "Debe subir su logo!!!"});
					return "redirect:/institution";
				}
			}
			institutionService.save(inst);
			redirect.addFlashAttribute("message", new String[] {"OK", "Registrado con éxito!!!"});
		}else {
			redirect.addFlashAttribute("message", new String[] {"ERROR", "Registra datos!!!"});
		}
		return "redirect:/institution";
	}

}
