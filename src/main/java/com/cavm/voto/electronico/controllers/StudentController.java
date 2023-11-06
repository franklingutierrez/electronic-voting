package com.cavm.voto.electronico.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cavm.voto.electronico.models.Grade;
import com.cavm.voto.electronico.models.Section;
import com.cavm.voto.electronico.models.Student;
import com.cavm.voto.electronico.services.IGradeService;
import com.cavm.voto.electronico.services.ISectionService;
import com.cavm.voto.electronico.services.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IGradeService gradeService;
	
	@Autowired
	private ISectionService sectionService;
	
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("")
	public String register(Model model) {
		Student newStudent = new Student();
		newStudent.setGrade(null);
		newStudent.setSection(null);
		model.addAttribute("title", "Estudiantes");
		model.addAttribute("ruta", "student");
		model.addAttribute("grades", gradeService.findAll());
		model.addAttribute("sections", sectionService.findAllByOrderById());
		model.addAttribute("newStudent", newStudent);
		return "student";
	}
	@PostMapping("")
	public String register(Model model, Student student) {
		model.addAttribute("title", "Estudiantes");
		model.addAttribute("ruta", "student");
		model.addAttribute("grades", gradeService.findAll());
		model.addAttribute("sections", sectionService.findAllByOrderById());
		if(student.getGrade() != null && student.getSection() != null) {
			if(!student.getDni().isBlank() && !student.getName().isBlank()) {
				Student stu = studentService.findByDni(student.getDni());
				if(stu ==null) {
					studentService.save(student);
					model.addAttribute("message", new String[] {"OK", "Alumno registrado!!"});
				}else model.addAttribute("message", new String[] {"ERROR", "El alumno con DNI  N°"+student.getDni()+" ya esta registrado!!"});
				
			}
			model.addAttribute("students", studentService.findAllGradeSection(student.getGrade(), student.getSection()));
		}
		else {
			model.addAttribute("message", new String[] {"ERROR", "Seleccione grado y sección!!"});
			model.addAttribute("students", null);
		}
		model.addAttribute("newStudent", student);
		model.addAttribute("newStudent2", student);
		
		return "student";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes flash) {
		Student stu = studentService.findById(id);
		stu.setDni("");
		stu.setName("");
		if(id > 0) {
			try {
				studentService.deleteById(id);
				flash.addFlashAttribute("message", new String[] {"OK", "Registro eliminado!!"});
			} catch (Exception e) {
				flash.addFlashAttribute("message", new String[] {"ERROR", "Registro tiene dependencias!!"});
			}
			
		}
		flash.addFlashAttribute("newStudent2", stu);
		flash.addFlashAttribute("students", studentService.findAllGradeSection(stu.getGrade(), stu.getSection()));
		return "redirect:/student";
	}
	
	@GetMapping("/import")
	public String importStudents(Model model) {
		List<Student> noRegisters = new ArrayList<>();
		model.addAttribute("ruta", "student-import");
		model.addAttribute("title", "Importar Estudiantes");
		//model.addAttribute("newStudent", newStudent);
		model.addAttribute("grades", gradeService.findAll());
		model.addAttribute("sections", sectionService.findAllByOrderById());
		model.addAttribute("noRegisters", noRegisters);
		return "student-import";
	}
	
	@PostMapping("/import")
	public String importStudents(Model model , @Param("grade") Long grade, @Param("section") Long section, @Param("file") MultipartFile file) throws EncryptedDocumentException, IOException {
		List<Student> noRegisters = new ArrayList<>();
		int count = 0;
		if(grade != null && section != null) {
			if(!file.isEmpty()) {
				Workbook workbook = WorkbookFactory.create(file.getInputStream());
			    Sheet sheet = workbook.getSheetAt(0);
			    //for (Row row : sheet) {
			    Grade grad = new Grade();
			    grad.setId(grade);
			    Section sec = new Section();
			    sec.setId(section);
			    String name;
			    String dni;
			    
			    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			        Row row = sheet.getRow(i);
			        Student student = new Student();
			        student.setGrade(grad);
			        student.setSection(sec);
			        if(row.getCell(0) != null && row.getCell(1)!=null) {
			        	//System.out.println("+++++:::"+row.getCell(0));
			            name = row.getCell(0).getStringCellValue();
			            if(row.getCell(1).getCellType() == CellType.NUMERIC) {
			            	dni = String.valueOf((long)row.getCell(1).getNumericCellValue());
			            }else dni = row.getCell(1).getStringCellValue();
			            if(!name.isBlank() && !dni.isBlank()) { // no deben estar en blanco 
			            	Student stuExist = studentService.findByDni(dni);
			            	student.setName(name);
			            	student.setDni(dni);
			            	if(stuExist == null) {
				            	studentService.save(student);
				            	count++;
			            	}else {
			            		noRegisters.add(student);
			            	}
			            	
			            }
			        }
			    }
			   
				model.addAttribute("message", new String[] {"OK","Se registraron "+count+" Alumnos"});
			}else {
				model.addAttribute("message", new String[] {"ERROR","Falta subir archivo!!"});
			}
			
		}else {
			model.addAttribute("message", new String[] {"ERROR","Seleccione grado y sección!!"});
		}
		
		model.addAttribute("ruta", "student-import");
		model.addAttribute("title", "Importar Estudiantes");
		model.addAttribute("grades", gradeService.findAll());
		model.addAttribute("sections", sectionService.findAllByOrderById());
		model.addAttribute("noRegisters", noRegisters);
		return "student-import";
	
	}

}
