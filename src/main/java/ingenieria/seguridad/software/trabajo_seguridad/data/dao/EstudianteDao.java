package ingenieria.seguridad.software.trabajo_seguridad.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Long> {
    
    @Query(value = "select * from estudiante u where u.email = ?0", nativeQuery = true)
    Estudiante getByEmail(String email);
}
