package br.com.ricardosander.imobiliaria.repository;

import br.com.ricardosander.imobiliaria.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
