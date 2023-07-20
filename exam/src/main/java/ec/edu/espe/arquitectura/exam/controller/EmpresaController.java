package ec.edu.espe.arquitectura.exam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.exam.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.exam.model.Empresa;
import ec.edu.espe.arquitectura.exam.service.EmpresaService;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Empresa> crear(@RequestBody EmpresaRQ empresa) {
        this.service.crearEmpresa(empresa);
        return ResponseEntity.ok().build();
    }

}
