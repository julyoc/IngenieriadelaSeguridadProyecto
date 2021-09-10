package ingenieria.seguridad.software.trabajo_seguridad.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Nrc;

public interface NrcDao extends JpaRepository<Nrc, Long> {
    
    @Query(value =  "select * from nrc u where u.nombre = ?0", nativeQuery = true)
    Nrc findByNrc(String nrc);

}
