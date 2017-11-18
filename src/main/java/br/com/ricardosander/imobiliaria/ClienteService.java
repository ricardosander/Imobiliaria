package br.com.ricardosander.imobiliaria;

import br.com.ricardosander.imobiliaria.model.Cliente;
import br.com.ricardosander.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    /**
     * Busca um cliente pelo seu id.
     *
     * @param id Id do cliente para a busca.
     * @return Cliente encontrado, null caso não exista id especificado.
     */
    public Cliente buscar(Long id) {
        return repository.findOne(id);
    }

    /**
     * Cria um novo cliente.
     *
     * @param cliente Cliente para ser criado.
     * @return Cliente criado.
     */
    public Cliente criar(Cliente cliente) {
        return repository.save(cliente);
    }

    /**
     * Busca todos os clientes.
     *
     * @return Lista com todos os clientes.
     */
    public List<Cliente> buscar() {
        return (List<Cliente>) repository.findAll();
    }
}
