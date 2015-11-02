package ar.edu.um.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.um.domain.Materia;
import ar.edu.um.repository.MateriaRepository;
import ar.edu.um.services.MateriaService;
@Service
@Transactional
public class MateriaServiceImpl implements MateriaService {
	private static final int PAGE_SIZE = 50;
	@Autowired
	private MateriaRepository dao;
	@Override
	public void create(Materia entity) {
		dao.save(entity);

	}

	@Override
	public void remove(Materia entity) {
		dao.delete(entity);

	}

	@Override
	public void update(Materia entity) {
		dao.save(entity);
	}

	@Override
	public Materia findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<Materia> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<Materia> findAll(Integer pageNumber, String campo, Sort.Direction orden) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, orden, campo);
		return dao.findAll(request);
	}
}
