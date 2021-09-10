package ingenieria.seguridad.software.trabajo_seguridad.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Estudiante;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Inscripcion;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Matricula;
import ingenieria.seguridad.software.trabajo_seguridad.data.models.Nrc;
import ingenieria.seguridad.software.trabajo_seguridad.data.services.IInscripcionService;
import ingenieria.seguridad.software.trabajo_seguridad.data.services.INrcService;

@RestController
@RequestMapping(value = "/api/Inscripcion")
public class InscripcionController {
    
    @Autowired
    private IInscripcionService inscripcionService;

    @Autowired
    private INrcService nrcService;

    private static final Logger logger = LoggerFactory.getLogger(LoggingApplicationListener.class);

    @PostMapping("/{id}")
    public void addMatricula(Estudiante estudiante, @RequestParam("nrcs") List<String> nrc, @RequestBody() String carrera) {
        var nrcs = new ArrayList<Nrc>();
        for (String nrc2 : nrc) {
            nrcs.add(nrcService.findByNrc(nrc2));
        }
        var matr = inscripcionService.inicializarInscripcion(estudiante, carrera);
        inscripcionService.addSomeNrc(matr, nrcs);
    }

    @DeleteMapping("/{id}")
    public void deleteAllMat(Matricula matricula) {
        inscripcionService.eliminarMatricula(matricula);
    }

    @GetMapping("/{id}")
    public List<Inscripcion> getInsc(Matricula matricula) {
        return inscripcionService.find(matricula);
    }
}
