package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ingenieria.seguridad.software.trabajo_seguridad.data.UserDetailsImpl;

@Service
public class UserDetailsService implements IUserDetailsService {

    @Autowired
    IEstudianteService estudianteService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return UserDetailsImpl.build(estudianteService.getByEmail(username));
    }
    
}
