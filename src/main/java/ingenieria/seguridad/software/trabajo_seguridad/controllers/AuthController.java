package ingenieria.seguridad.software.trabajo_seguridad.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingenieria.seguridad.software.trabajo_seguridad.data.UserDetailsImpl;
import ingenieria.seguridad.software.trabajo_seguridad.data.jwt.JwtUtils;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.JwtResponse;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.LoginRequest;
import ingenieria.seguridad.software.trabajo_seguridad.data.services.IEstudianteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
	AuthenticationManager authenticationManager;

    @Autowired
    IEstudianteService estudianteService;

    @Autowired
	PasswordEncoder encoder;

    @Autowired
	JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Estudiante estudiante) {
        
        var est = estudianteService.getByEmail(estudiante.getEmail());

        if (est == null) {
            return ResponseEntity.ok("El usuario ya existe");
        }
        
        return ResponseEntity.ok("Usuario registrado");
    }
}
