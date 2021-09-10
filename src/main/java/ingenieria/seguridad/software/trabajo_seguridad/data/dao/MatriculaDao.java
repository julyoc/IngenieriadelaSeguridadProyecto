package ingenieria.seguridad.software.trabajo_seguridad.data.dao;

import org.springframework.data.repository.CrudRepository;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Matricula;

public interface MatriculaDao extends CrudRepository<Matricula, Long> {
    
}
