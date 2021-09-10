package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ingenieria.seguridad.software.trabajo_seguridad.data.dao.NrcDao;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Nrc;

@Service
public class NrcService implements INrcService {

    @Autowired
    private NrcDao nrcDao;

    @Override
    @Transactional(readOnly = true)
    public List<Nrc> getAll() {
        return (List<Nrc>) nrcDao.findAll();
    }

    @Override
    @Transactional
    public void save(Nrc data) {
        nrcDao.save(data);
    }

    @Override
    @Transactional
    public void delete(Nrc data) {
        nrcDao.delete(data);
    }

    @Override
    @Transactional(readOnly = true)
    public Nrc getById(Nrc data) {
        return nrcDao.findById(data.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Nrc getById(long id) {
        return nrcDao.findById(id).orElse(null);
    }

    @Override
    public Nrc findByNrc(String nrc) {
        // TODO Auto-generated method stub
        return nrcDao.findByNrc(nrc);
    }
    
}
