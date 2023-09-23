package com.example.pruebatcc.services;

import com.example.pruebatcc.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> obtenerClientes();
    Optional<Cliente> obtenerClienteById(Long id);
    Cliente crearCliente(Cliente cliente);
    Cliente actualizarCliente(Long id, Cliente cliente);
    void eliminarCliente(Long id);

}
