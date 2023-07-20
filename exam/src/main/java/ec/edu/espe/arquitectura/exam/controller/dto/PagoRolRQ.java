package ec.edu.espe.arquitectura.exam.controller.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagoRolRQ {
    private Integer mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private String cuentaPrincipal;

    private List<EmpleadosPagoRQ> empleadosPago;
}
