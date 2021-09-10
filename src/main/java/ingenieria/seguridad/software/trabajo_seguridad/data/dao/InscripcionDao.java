package ingenieria.seguridad.software.trabajo_seguridad.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Inscripcion;

public interface InscripcionDao extends JpaRepository<Inscripcion, Long> {

    @Query(value = "select * from inscripcion u where u.id_mat = ?0", nativeQuery = true)
    Iterable<Inscripcion> findByMatricula(long idMatricula);

    @Query(value = "delete from inscripcion where id_mat = ?0", nativeQuery = true)
    void deleteAllMatricula(long idMatricula);

}
