package com.cavm.elecciones.escolares.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cavm.elecciones.escolares.models.CandidateList;
import com.cavm.elecciones.escolares.models.ListRole;
import com.cavm.elecciones.escolares.services.ICandidateListService;
import com.cavm.elecciones.escolares.services.IListRoleService;
import com.cavm.elecciones.escolares.services.IRoleService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/list")
public class CandidateListController {
	
	@Autowired
	private ICandidateListService candidateListService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IListRoleService listRoleService;
	
	@GetMapping
	public String Candidate(Model model) {
		CandidateList newList = new CandidateList();
		model.addAttribute("ruta", "list");
		model.addAttribute("title", "Listas");
		model.addAttribute("lists", candidateListService.findAllByOrderById());
		model.addAttribute("newList", newList);
		return "list";
	}
	
	@PostMapping
	public String Candidate(@Valid CandidateList newList, BindingResult result, @RequestParam MultipartFile imgCandidate, @RequestParam MultipartFile logo, RedirectAttributes flash) throws IOException {
		if(result.hasErrors()) {
			/*result.getAllErrors().forEach(data->{
				System.out.println(data);
			});*/
			//return "redirect:/list";
		}
		Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
		String rootPath = directorioRecursos.toFile().getAbsolutePath();
		if(!imgCandidate.isEmpty()) {
			String extension 	= StringUtils.getFilenameExtension(imgCandidate.getOriginalFilename());
			String name			= newList.getName().replace(" ", "_");
			Path rutaCompleta	= Paths.get(rootPath +"//"+name+"_cand."+extension);
			byte[] bytes 		= imgCandidate.getBytes();
			Files.write(rutaCompleta, bytes);
			newList.setImgCandidate(name+"_cand."+extension);
		}
		if(!logo.isEmpty()) {
			String extension 	= StringUtils.getFilenameExtension(logo.getOriginalFilename());
			String name			= newList.getName().replace(" ", "_");
			byte[] bytes2 		= logo.getBytes();
			Path rutaCompleta2	= Paths.get(rootPath +"//"+name+"_logo."+extension);
			Files.write(rutaCompleta2, bytes2);
			newList.setLogo(name+"_logo."+extension);
		}
		candidateListService.save(newList);
		/*}else {
			result.getAllErrors().forEach(data->{
				System.out.println(data);
			});
		}*/
		flash.addFlashAttribute("message","Registro exitoso");
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		if(id>0) {
			candidateListService.delete(id);
		}
		return "redirect:/list";
	}
	
	@GetMapping("/role/{id}")
	public String listRole(@PathVariable Long id, Model model) {
		//CandidateList candidateList = new CandidateList();
		//candidateList.setId(id);
		System.out.println("estooo::"+id);
		ListRole newListRole = new ListRole();
		model.addAttribute("list", candidateListService.findById(id));
		model.addAttribute("title", "Lista - Candidatos");
		model.addAttribute("ruta", "list");
		model.addAttribute("roles",roleService.findAllByOrderByOrder());
		model.addAttribute("listRoles", listRoleService.listRoleByList(id));
		model.addAttribute("newListRole",newListRole);
		return "list-role";
	}
	@GetMapping("/role/delete/{listId}/{id}")
	public String delete(@PathVariable Long listId, @PathVariable Long id, Model model) {
		if(id>0) {
			listRoleService.deleteById(id);
		}
		return "redirect:/list/role/"+listId;
	}
	
	@PostMapping("/role/{id}")
	public String listRole(@Valid ListRole newListRole, BindingResult result, @PathVariable Long id, RedirectAttributes flash) {
		CandidateList candList = new CandidateList();
		candList.setId(id);
		newListRole.setCandidateList(candList);
		if(result.hasErrors()) {
			result.getAllErrors().forEach(data->{
				System.out.println(data);
			});
			return "redirect:/list/role/"+id;
		}
		try {
			listRoleService.save(newListRole);
		}catch(Exception e) {
			ListRole listRole = listRoleService.ListRoleByListAndRole(newListRole.getCandidateList().getId(), newListRole.getRole().getId());
			if(listRole != null) {
				flash.addFlashAttribute("message", new String[] {"ERROR", "El rol "+newListRole.getRole().getName()+" ya está registrado!!!"});
			}else {
				flash.addFlashAttribute("message", new String[] {"ERROR", e.getMessage()});
			}
			return "redirect:/list/role/"+id;
		}
		flash.addFlashAttribute("message", new String[] {"OK", "Rol registrado con exito!!"});
		return "redirect:/list/role/"+id;
	}

}
