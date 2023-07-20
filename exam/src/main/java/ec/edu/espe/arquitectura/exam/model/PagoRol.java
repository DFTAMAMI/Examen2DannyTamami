package ec.edu.espe.arquitectura.exam.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "pagoRol")
@Getter
@Setter
@Builder
public class PagoRol {

    @Id
    private String id;

    private Integer mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;

    private List<EmpleadosPago> pagos;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rucEmpresa == null) ? 0 : rucEmpresa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PagoRol other = (PagoRol) obj;
        if (rucEmpresa == null) {
            if (other.rucEmpresa != null)
                return false;
        } else if (!rucEmpresa.equals(other.rucEmpresa))
            return false;
        return true;
    }

}
