package ec.edu.espe.arquitectura.exam.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoRQ {
    private String cedulaIdentidad;
    private String apellidos;
    private String nombres;
    private String numeroCuenta;
}
