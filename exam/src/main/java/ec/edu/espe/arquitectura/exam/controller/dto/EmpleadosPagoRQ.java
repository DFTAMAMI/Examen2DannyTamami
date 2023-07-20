package ec.edu.espe.arquitectura.exam.controller.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadosPagoRQ {
    private String numeroCuenta;
    private BigDecimal valor;
}
