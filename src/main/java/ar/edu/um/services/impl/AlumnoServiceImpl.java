package ar.edu.um.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.um.domain.Alumno;
import ar.edu.um.repository.AlumnoRepository;
import ar.edu.um.services.AlumnoService;
@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {
	private static final int PAGE_SIZE = 50;
	@Autowired
	private AlumnoRepository dao;
	@Override
	public void create(Alumno entity) {
		dao.save(entity);

	}

	@Override
	public void remove(Alumno entity) {
		dao.delete(entity);

	}

	@Override
	public void update(Alumno entity) {
		dao.save(entity);
	}

	@Override
	public Alumno findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<Alumno> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<Alumno> findAll(Integer pageNumber, String campo, Sort.Direction orden) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, orden, campo);
		return dao.findAll(request);
	}

}
