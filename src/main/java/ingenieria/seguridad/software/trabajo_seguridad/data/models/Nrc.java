package ingenieria.seguridad.software.trabajo_seguridad.data.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "nrc")
public class Nrc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nrc")
    private long id;
    @NotEmpty
    private int creditos;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String departameno;

    @OneToMany
    private List<Inscripcion> inscripcions;
    
}
