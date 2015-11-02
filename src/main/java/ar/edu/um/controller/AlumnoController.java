package ar.edu.um.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.um.domain.Alumno;
import ar.edu.um.domain.Carrera;
import ar.edu.um.form.CarreraEditor;
import ar.edu.um.services.AlumnoService;
import ar.edu.um.services.CarreraService;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private CarreraService carreraService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AlumnoController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		for (Alumno alumno : alumnoService.findAll()) {
			logger.info(alumno.getApellido());
		}
	
		model.addAttribute("alumnos", alumnoService.findAll());
		return "alumnos/tabla";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Alumno> list(Model model) {
		return alumnoService.findAll();
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevo(Model model){
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("carreras", carreraService.findAll());
		return "alumnos/nuevo";
	}
	
	@RequestMapping(value="/nuevo", method= RequestMethod.POST)
	public String form(@Valid Alumno alumno, BindingResult result,
			Model model){
		if (!result.hasErrors()) {
			alumnoService.create(alumno);
			return "redirect:/alumnos/";
		} else {
			for (ObjectError error : result.getAllErrors()) {
				logger.info("Validation error: " + error.getDefaultMessage());
			}
		}
		model.addAttribute("carreras", carreraService.findAll());
		return "alumnos/nuevo";
	}
	
	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String borrar(@PathVariable("id") Integer id, Model model) {
		Alumno alumno = alumnoService.findById(id);
		if(alumno != null){
			alumnoService.remove(alumno);
		}
		return "redirect:/alumnos/";
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,	ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Carrera.class, new CarreraEditor(this.carreraService));
	}
}
