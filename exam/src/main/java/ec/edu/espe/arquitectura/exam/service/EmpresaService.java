package ec.edu.espe.arquitectura.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.exam.controller.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.exam.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.exam.model.Empleado;
import ec.edu.espe.arquitectura.exam.model.Empresa;
import ec.edu.espe.arquitectura.exam.repository.EmpresaRepository;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void crearEmpresa(EmpresaRQ rq) {
        Empresa empresa = this.transform(rq);

        List<Empleado> empleados = new ArrayList<>();
        for (EmpleadoRQ empleadoRQ : rq.getEmpleados()) {
            Empleado empleado = new Empleado();
            empleado.setNumeroCuenta(empleadoRQ.getNumeroCuenta());
            empleado.setApellidos(empleadoRQ.getApellidos());
            empleado.setNombres(empleadoRQ.getNombres());
            empleado.setCedulaIdentidad(empleadoRQ.getCedulaIdentidad());
            empleados.add(empleado);
        }
        empresa.setEmpleados(empleados);
        this.empresaRepository.save(empresa);
    }

    private Empresa transform(EmpresaRQ rq) {
        Empresa client = Empresa
                .builder()
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .razonSocial(rq.getRazonSocial())
                .ruc(rq.getRuc())
                .build();
        return client;
    }
}
