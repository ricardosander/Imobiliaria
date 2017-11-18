package br.com.ricardosander.imobiliaria;

import br.com.ricardosander.imobiliaria.model.Cliente;
import br.com.ricardosander.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente buscar(Long id) {
        return repository.findOne(id);
    }

}
