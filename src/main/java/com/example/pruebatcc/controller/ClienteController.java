package com.example.pruebatcc.controller;

import com.example.pruebatcc.exception.RegistroNoExiste;
import com.example.pruebatcc.model.Cliente;
import com.example.pruebatcc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.obtenerClienteById(id).orElseThrow(() -> new RegistroNoExiste("No Existe el Cliente con ID " + id));
            return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteActualizar = clienteService.obtenerClienteById(id).orElseThrow(() -> new RegistroNoExiste("No Existe el Cliente con ID " + id));
            return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
