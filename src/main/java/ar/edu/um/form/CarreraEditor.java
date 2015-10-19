package ar.edu.um.form;

import java.beans.PropertyEditorSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.um.domain.Carrera;
import ar.edu.um.services.CarreraService;

public class CarreraEditor extends PropertyEditorSupport {

	@Autowired
	private CarreraService carreraService;
	private static final Logger logger = LoggerFactory.getLogger(CarreraEditor.class);

	public CarreraEditor(CarreraService carreraService) {
		this.carreraService = carreraService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Carrera carrera = carreraService.findById(Integer.parseInt(text));
		setValue(carrera);
	}

}
