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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Matricula;
import ingenieria.seguridad.software.trabajo_seguridad.data.services.IMatriculaService;

@RestController
@RequestMapping(value = "/api/Matricula")
public class MatriculaController {
    
    @Autowired
    private IMatriculaService matriculaService;

    private static final Logger logger = LoggerFactory.getLogger(LoggingApplicationListener.class);

    @GetMapping("/")
    public List<Matricula> getAllMatriculas() {
        logger.info("GET /api/Matricula/:");
        return matriculaService.getAll();
    }

    @GetMapping("/{id}")
    public Matricula getOneMatricula(Matricula data) {
        logger.info("GET /api/Matricula/{id}:");
        return matriculaService.getById(data);
    }

    @PostMapping("/{id}")
    public void saveMatricula(Estudiante estudiante, @RequestBody Matricula matricula) {
        logger.info("POST /api/Matricula/:");
        matricula.setEstudiante(estudiante);
        matriculaService.save(matricula);
    }

    @PutMapping("/{id}")
    public void upDateMatricula(Matricula matricula) {
        logger.info("PUT /api/Matricula/{id}:");
        matriculaService.save(matricula);
    }

    @DeleteMapping("/{id}")
    public void deleteMatricula(Matricula matricula) {
        logger.info("DELETE /api/Matricula/{id}:");
        matriculaService.delete(matricula);
    }

}
