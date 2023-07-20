package ec.edu.espe.arquitectura.exam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.exam.model.PagoRol;

public interface PagoRolRepository extends MongoRepository<PagoRol, String>{
    
}
