package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import java.util.List;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Inscripcion;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Matricula;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Nrc;

public interface IInscripcionService extends IServices<Inscripcion> {

    public List<Inscripcion> find(Matricula matricula);

    public Matricula inicializarInscripcion(Estudiante estudiante, String carrera);

    public void addOneNrc(Matricula matricula, Nrc nrc);

    public void addSomeNrc(Matricula matricula, List<Nrc> nrc);

    public void eliminarMatricula(Matricula matricula);

}
