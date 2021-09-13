package ingenieria.seguridad.software.trabajo_seguridad.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

	private Long id;

    private String username;

	private String email;

	@JsonIgnore
	private String password;

    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl(long id2, String email2, String contrasenia, List<GrantedAuthority> authorities) {
        setId(id2);
        setEmail(email2);
        username = email2;
        password = contrasenia;
        this.authorities = authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public static UserDetailsImpl build(Estudiante est) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(est.getRole()));

		return new UserDetailsImpl(
				est.getId(), 
				est.getEmail(),
				est.getContrasenia(), 
				authorities);
	}
    
}
