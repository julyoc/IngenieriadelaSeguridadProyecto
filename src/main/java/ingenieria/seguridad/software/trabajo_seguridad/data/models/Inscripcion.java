package ingenieria.seguridad.software.trabajo_seguridad.data.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insc")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_mat")
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "id_nrc")
    private Nrc nrc;
    
    @NotEmpty
    private Date fecha = new Date();

}
