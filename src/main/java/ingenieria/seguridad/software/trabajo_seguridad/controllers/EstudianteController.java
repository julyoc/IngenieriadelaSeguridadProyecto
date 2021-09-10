package ingenieria.seguridad.software.trabajo_seguridad.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;
import ingenieria.seguridad.software.trabajo_seguridad.data.services.IEstudianteService;

@RestController
@RequestMapping(value = "/api/Estudiante")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    private static final Logger logger = LoggerFactory.getLogger(LoggingApplicationListener.class);

    @GetMapping("/")
    public List<Estudiante> getAllEstudiante() {
        logger.info("GET /api/Estudiante/:");
        return estudianteService.getAll();
    }

    @GetMapping("/{id}")
    public Estudiante getByEstudiante(Estudiante estudiante) {
        logger.info("GET /api/Estudiante/{id}:");
        return estudianteService.getById(estudiante);
    }

    @PostMapping("/")
    public void saveEstudiante(Estudiante estudiante) {
        logger.info("POST /api/Estudiante/:");
        estudianteService.save(estudiante);
    }

    @PutMapping("/{id}")
    public void updateEstudiante(Estudiante estudiante) {
        logger.info("PUT /api/Estudiante/{id}:");
        estudianteService.save(estudiante);
    }

    @DeleteMapping("/{id}")
    public void deleteEstudiante(Estudiante estudiante) {
        logger.info("DELETE /api/Estudiante/{id}:");
        estudianteService.delete(estudiante);
    }
}
