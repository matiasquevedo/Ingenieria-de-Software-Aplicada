package ar.edu.um.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import ar.edu.um.domain.Carrera;

public interface CarreraService {
	void create(final Carrera entity);
	void remove(final Carrera entity);
	void update(final Carrera entity);
	Carrera findById(final Integer id);

	List<Carrera> findAll();
	Page<Carrera> findAll(Integer pageNumber, String campo, Sort.Direction orden);
}
