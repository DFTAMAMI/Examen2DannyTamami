package ec.edu.espe.arquitectura.exam.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "empleado")
@Getter
@Setter
@Builder
public class Empresa {

    @Id
    private String id;

    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;
    
    private List<Empleado> empleados;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ruc == null) ? 0 : ruc.hashCode());
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
        Empresa other = (Empresa) obj;
        if (ruc == null) {
            if (other.ruc != null)
                return false;
        } else if (!ruc.equals(other.ruc))
            return false;
        return true;
    }

}
