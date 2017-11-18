package br.com.ricardosander.imobiliaria.controller;

import br.com.ricardosander.imobiliaria.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> ver(@PathVariable Long id) {
        return new ResponseEntity<>(new Cliente(id, "Ricardo"), HttpStatus.OK);
    }

}
