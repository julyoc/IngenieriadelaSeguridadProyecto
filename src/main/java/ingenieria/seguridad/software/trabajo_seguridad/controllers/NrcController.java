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

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Nrc;
import ingenieria.seguridad.software.trabajo_seguridad.data.services.INrcService;

@RestController
@RequestMapping(value = "/api/Nrc")
public class NrcController {
    
    @Autowired
    private INrcService nrcService;

    private static final Logger logger = LoggerFactory.getLogger(LoggingApplicationListener.class);

    @GetMapping("/")
    public List<Nrc> getAllNrcs() {
        logger.info("GET /api/Nrc/:");
        return nrcService.getAll();
    }

    @GetMapping("/{id}")
    public Nrc getOneNrc(Nrc nrc) {
        logger.info("GET /api/Nrc/{id}:");
        return nrcService.getById(nrc);
    }
    
    @PostMapping("/")
    public void saveNrc(Nrc nrc) {
        logger.info("POST /api/Nrc/:");
        nrcService.save(nrc);
    }
    
    @PutMapping("/{id}")
    public void updateNrc(Nrc nrc) {
        logger.info("PUT /api/Nrc/{id}:");
        nrcService.save(nrc);
    }

    @DeleteMapping("/{id}")
    public void deleteNrc(Nrc nrc) {
        logger.info("DELETE /api/Nrc/{id}:");
        nrcService.delete(nrc);
    }

}
