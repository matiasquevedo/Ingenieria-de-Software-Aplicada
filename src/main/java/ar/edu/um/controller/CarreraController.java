package ar.edu.um.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.um.domain.Carrera;
import ar.edu.um.services.CarreraService;

@Controller
@RequestMapping("/carreras")
public class CarreraController {
	
	@Autowired
	private CarreraService carreraService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AlumnoController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("carreras", carreraService.findAll());
		return "carreras/tabla";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevo(Model model){
		model.addAttribute("carrera", new Carrera());
		return "carreras/nuevo";
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public String editar(@PathVariable("id") Integer id, Model model) {
		Carrera carrera = carreraService.findById(id);
		if(carrera != null){
			model.addAttribute("carrera", carrera);
			return "carreras/editar";
		}
		return "redirect:/carreras/";
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public String formEditar(@PathVariable("id") Integer id,
			@Valid Carrera carrera, BindingResult result, Model model
			) {
		
		if (!result.hasErrors()) {
			carreraService.update(carrera);
			return "redirect:/carreras/";
		  } else {
			for (ObjectError error : result.getAllErrors()) {
				logger.info("Validation error: " + error.getDefaultMessage());
			}
		}
		
		return "redirect:/carreras/";
	}
	
	@RequestMapping(value="/nuevo", method= RequestMethod.POST)
	public String form(@Valid Carrera carrera, BindingResult result,
			Model model){
		if (!result.hasErrors()) {
			carreraService.create(carrera);
			return "redirect:/carreras/";
		} else {
			for (ObjectError error : result.getAllErrors()) {
				logger.info("Validation error: " + error.getDefaultMessage());
			}
		}
		return "carreras/nuevo";
	}
	
	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String borrar(@PathVariable("id") Integer id, Model model) {
		Carrera carrera = carreraService.findById(id);
		if(carrera != null){
			carreraService.remove(carrera);
		}
		return "redirect:/carreras/";
	}
	
}
