package dev.erick.rbs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.erick.rbs.model.Cliente;
import dev.erick.rbs.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(@RequestHeader Map<String, String> headers) {
        try {
            List<Cliente> items = new ArrayList<Cliente>();

            this.clienteRepository.findAll().forEach(items::add);

            if (items.isEmpty()) {
                logger.info(String.format("Nenhum cliente encontrado (host: %s).", headers.get("host")));
                return ResponseEntity.noContent().build();
            }

            logger.info(String.format("Clientes retornados (host: %s).", headers.get("host")));
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}