package com.example.pruebatcc.services;

import com.example.pruebatcc.model.Cliente;
import com.example.pruebatcc.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.saveAndFlush(cliente);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new EntityNotFoundException("El Cliente con ID " + id + " no existe.");
        }
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
