package ec.edu.espe.arquitectura.exam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.exam.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.exam.model.PagoRol;
import ec.edu.espe.arquitectura.exam.service.PagoRolService;

@RestController
@RequestMapping("/api/v1/pagoRol")
public class PagoRolController {
    private final PagoRolService service;

    public PagoRolController(PagoRolService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PagoRol> crear(@RequestBody PagoRolRQ pagoRolRQ) {
        this.service.crearPagoRol(pagoRolRQ);
        return ResponseEntity.ok().build();
    }
}
