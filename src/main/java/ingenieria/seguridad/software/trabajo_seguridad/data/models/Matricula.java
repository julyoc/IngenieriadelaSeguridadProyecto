package ingenieria.seguridad.software.trabajo_seguridad.data.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mat")
    private long id;

    @NotEmpty
    private Date fecha = new Date();

    @NotEmpty
    private String carrera;

    @ManyToOne
    @JoinColumn(name = "id_est")
    private Estudiante estudiante;

    @OneToMany
    private List<Inscripcion> inscripcions;
    
}
