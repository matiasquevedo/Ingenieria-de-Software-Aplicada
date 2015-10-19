package ar.edu.um.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.um.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
