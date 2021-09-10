package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ingenieria.seguridad.software.trabajo_seguridad.data.dao.MatriculaDao;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Matricula;

@Service
public class MatriculaService implements IMatriculaService {

    @Autowired
    private MatriculaDao matriculaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Matricula> getAll() {
        return (List<Matricula>) matriculaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Matricula data) {
        matriculaDao.save(data);
    }

    @Override
    @Transactional
    public void delete(Matricula data) {
        matriculaDao.delete(data);
    }

    @Override
    @Transactional(readOnly = true)
    public Matricula getById(Matricula data) {
        return matriculaDao.findById(data.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Matricula getById(long id) {
        return matriculaDao.findById(id).orElse(null);
    }
    
}
