package br.com.ricardosander.imobiliaria.controller;

import br.com.ricardosander.imobiliaria.ClienteService;
import br.com.ricardosander.imobiliaria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> verTodos() {
        return new ResponseEntity<>(service.buscar(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> ver(@PathVariable Long id) {

        Cliente cliente = service.buscar(id);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> criar(@RequestBody Cliente cliente, UriComponentsBuilder builder) {

        cliente = service.criar(cliente);
        if (cliente.getId() <= 0) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        UriComponents uriComponents = builder.path("/cliente/{id}").buildAndExpand(cliente.getId());

        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity alterar(@PathVariable Long id, @RequestBody Cliente cliente) {

        if (service.buscar(id) == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        cliente.setId(id);
        Cliente clienteAtualizado = service.atualizar(cliente);
        if (clienteAtualizado == null || cliente.getId() != clienteAtualizado.getId()) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletar(@PathVariable Long id) {

        Cliente cliente = service.buscar(id);
        if (cliente == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        if (!service.remover(cliente)) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

}
