package ar.edu.um.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.um.domain.Carrera;
import ar.edu.um.domain.Materia;
import ar.edu.um.form.CarreraEditor;
import ar.edu.um.services.CarreraService;
import ar.edu.um.services.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	private MateriaService materiaService;
	@Autowired
	private CarreraService carreraService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AlumnoController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("materias", materiaService.findAll());
		return "materias/tabla";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevo(Model model){
		model.addAttribute("materia", new Materia());
		model.addAttribute("carreras", carreraService.findAll());
		return "materias/nuevo";
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public String editar(@PathVariable("id") Integer id, Model model) {
		Materia materia= materiaService.findById(id);
		if(materia != null){
			model.addAttribute("materia", materia);
			model.addAttribute("carreras", carreraService.findAll());
			return "materias/editar";
		}
		return "redirect:/materias/";
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public String formEditar(@PathVariable("id") Integer id,
			@Valid Materia materia, BindingResult result, Model model
			) {
		
		if (!result.hasErrors()) {
			materiaService.update(materia);
			return "redirect:/materias/";
		  } else {
			for (ObjectError error : result.getAllErrors()) {
				logger.info("Validation error: " + error.getDefaultMessage());
			}
		}
		model.addAttribute("carreras", carreraService.findAll());
		return "materias/editar";
	}
	
	@RequestMapping(value="/nuevo", method= RequestMethod.POST)
	public String form(@Valid Materia materia, BindingResult result,
			Model model){
		if (!result.hasErrors()) {
			materiaService.create(materia);
			return "redirect:/materias/";
		} else {
			for (ObjectError error : result.getAllErrors()) {
				logger.info("Validation error: " + error.getDefaultMessage());
			}
		}
		model.addAttribute("carreras", carreraService.findAll());
		return "materias/nuevo";
	}
	
	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String borrar(@PathVariable("id") Integer id, Model model) {
		Materia materia = materiaService.findById(id);
		if(materia != null){
			materiaService.remove(materia);
		}
		return "redirect:/materias/";
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,	ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Carrera.class, new CarreraEditor(this.carreraService));
	}
}
