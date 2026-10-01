package com.udla.arquitectura.demo.service;

import com.udla.arquitectura.demo.model.Producto;
import com.udla.arquitectura.demo.repository.RepositorioProductoEnMemoria; // O ProductoRepository
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    // Asegúrate de que el tipo coincida con tu repositorio inyectado
    private final RepositorioProductoEnMemoria repository;

    public ProductoServiceImpl(RepositorioProductoEnMemoria repository) {
        this.repository = repository;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        System.out.println("Servicio Real: Consultando productos desde el repositorio...");
        // IMPORTANTE: Cambia "listar()" por el método real que use tu repositorio para devolver todo
        return repository.listarTodos(); 
    }

    @Override
    public Producto buscarPorId(Long id) {
        // IMPORTANTE: Cambia "buscarPorId(id)" por el método real que use tu repositorio
        return repository.buscarPorId(id);
    }
}