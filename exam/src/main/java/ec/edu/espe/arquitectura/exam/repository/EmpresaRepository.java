package ec.edu.espe.arquitectura.exam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.exam.model.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String>{
    
}
