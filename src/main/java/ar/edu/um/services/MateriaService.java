package ar.edu.um.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import ar.edu.um.domain.Materia;

public interface MateriaService {
	void create(final Materia entity);
	void remove(final Materia entity);
	void update(final Materia entity);
	Materia findById(final Integer id);

	List<Materia> findAll();
	Page<Materia> findAll(Integer pageNumber, String campo, Sort.Direction orden);
}
