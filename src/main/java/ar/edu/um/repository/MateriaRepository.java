package ar.edu.um.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.um.domain.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}
