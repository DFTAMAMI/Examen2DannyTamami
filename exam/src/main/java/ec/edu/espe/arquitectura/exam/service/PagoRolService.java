package ec.edu.espe.arquitectura.exam.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.exam.controller.dto.EmpleadosPagoRQ;
import ec.edu.espe.arquitectura.exam.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.exam.model.EmpleadosPago;
import ec.edu.espe.arquitectura.exam.model.PagoRol;
import ec.edu.espe.arquitectura.exam.repository.PagoRolRepository;

@Service
public class PagoRolService {
    private final PagoRolRepository pagoRolRepository;

    public PagoRolService(PagoRolRepository pagoRolRepository) {
        this.pagoRolRepository = pagoRolRepository;
    }

    public void crearPagoRol(PagoRolRQ rq) {
        BigDecimal total = BigDecimal.ZERO;
        PagoRol pagoRol = this.transform(rq);
        pagoRol.setValorReal(BigDecimal.valueOf(0));
        List<EmpleadosPago> pagos = new ArrayList<>();
        for (EmpleadosPagoRQ empleadoRQ : rq.getEmpleadosPago()) {
            EmpleadosPago pago = new EmpleadosPago();
            pago.setNumeroCuenta(empleadoRQ.getNumeroCuenta());
            pago.setValor(empleadoRQ.getValor());
            pago.setEstado("PEN");
            pagos.add(pago);
            total = total.add(empleadoRQ.getValor());
        }
        pagoRol.setValorTotal(total);
        pagoRol.setPagos(pagos);
        this.pagoRolRepository.save(pagoRol);
    }

    private PagoRol transform(PagoRolRQ rq) {
        PagoRol pagoRol = PagoRol
                .builder()
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .fechaProceso(rq.getFechaProceso())
                .mes(rq.getMes())
                .rucEmpresa(rq.getRucEmpresa())
                .build();
        return pagoRol;
    }
}
