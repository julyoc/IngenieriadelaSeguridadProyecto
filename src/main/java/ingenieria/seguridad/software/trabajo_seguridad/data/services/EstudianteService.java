package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ingenieria.seguridad.software.trabajo_seguridad.data.dao.EstudianteDao;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;

@Service
public class EstudianteService implements IEstudianteService {
    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> getAll() {
        return (List<Estudiante>) estudianteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Estudiante data) {
        estudianteDao.save(data);
    }

    @Override
    @Transactional
    public void delete(Estudiante data) {
        estudianteDao.delete(data);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante getById(Estudiante data) {
        return estudianteDao.findById(data.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante getById(long id) {
        return estudianteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante getByEmail(String email) {
        // TODO Auto-generated method stub
        return estudianteDao.getByEmail(email);
    }

}
