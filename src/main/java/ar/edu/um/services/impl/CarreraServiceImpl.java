package ar.edu.um.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.um.domain.Carrera;
import ar.edu.um.repository.CarreraRepository;
import ar.edu.um.services.CarreraService;
@Service
@Transactional
public class CarreraServiceImpl implements CarreraService {
	private static final int PAGE_SIZE = 50;
	@Autowired
	private CarreraRepository dao;
	@Override
	public void create(Carrera entity) {
		dao.save(entity);

	}

	@Override
	public void remove(Carrera entity) {
		dao.delete(entity);

	}

	@Override
	public void update(Carrera entity) {
		dao.save(entity);
	}

	@Override
	public Carrera findById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<Carrera> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<Carrera> findAll(Integer pageNumber, String campo, Sort.Direction orden) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, orden, campo);
		return dao.findAll(request);
	}

}
