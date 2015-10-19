package ar.edu.um.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import ar.edu.um.domain.Alumno;

public interface AlumnoService {
	void create(final Alumno entity);
	void remove(final Alumno entity);
	void update(final Alumno entity);
	Alumno findById(final Integer id);

	List<Alumno> findAll();
	Page<Alumno> findAll(Integer pageNumber, String campo, Sort.Direction orden);
}
