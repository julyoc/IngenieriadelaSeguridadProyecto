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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_est")
    private long id;
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidos;
    @NotNull
    private int edad;
    @NotEmpty
    private String dni;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String contrasenia;

    private String role = "USER";
    
    @OneToMany
    private List<Matricula> matricula;
}
