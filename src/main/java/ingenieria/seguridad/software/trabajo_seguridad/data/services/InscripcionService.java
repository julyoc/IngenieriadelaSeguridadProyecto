package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ingenieria.seguridad.software.trabajo_seguridad.data.dao.InscripcionDao;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Inscripcion;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Matricula;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Nrc;

@Service
public class InscripcionService implements IInscripcionService {

    @Autowired
    private InscripcionDao inscripcionDao;

    @Autowired
    private IMatriculaService matriculaService;

    @Override
    @Transactional(readOnly = true)
    public List<Inscripcion> getAll() {
        return (List<Inscripcion>) inscripcionDao.findAll();
    }

    @Override
    @Transactional
    public void save(Inscripcion data) {
        inscripcionDao.save(data);
    }

    @Override
    @Transactional
    public void delete(Inscripcion data) {
        inscripcionDao.delete(data);
    }

    @Override
    @Transactional(readOnly = true)
    public Inscripcion getById(Inscripcion data) {
        return inscripcionDao.findById(data.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Inscripcion getById(long id) {
        return inscripcionDao.findById(id).orElse(null);
    }

    @Override
    public Matricula inicializarInscripcion(Estudiante estudiante, String carrera) {
        // TODO Auto-generated method stub
        Matricula newMat = new Matricula();
        newMat.setCarrera(carrera);
        newMat.setEstudiante(estudiante);
        newMat.setFecha((java.sql.Date) new Date());
        matriculaService.save(newMat);
        return newMat;
    }

    @Override
    public void addOneNrc(Matricula matricula, Nrc nrc) {
        Inscripcion ins = new Inscripcion();
        ins.setMatricula(matricula);
        ins.setNrc(nrc);
        save(ins);
    }

    @Override
    public void addSomeNrc(Matricula matricula, List<Nrc> nrc) {
        for (Nrc n: nrc) {
            addOneNrc(matricula, n);
        }
    }

    @Override
    public void eliminarMatricula(Matricula matricula) {
        // TODO Auto-generated method stub
        inscripcionDao.deleteAllMatricula(matricula.getId());
        matriculaService.delete(matricula);
    }

    @Override
    public List<Inscripcion> find(Matricula matricula) {
        // TODO Auto-generated method stub
        return (List<Inscripcion>) inscripcionDao.findByMatricula(matricula.getId());
    }
    
}
