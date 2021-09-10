package ingenieria.seguridad.software.trabajo_seguridad.data.dao;

import org.springframework.data.repository.CrudRepository;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;

public interface EstudianteDao extends CrudRepository<Estudiante, Long> {
    
}
