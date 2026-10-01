package com.udla.arquitectura.demo.controller;

import com.udla.arquitectura.demo.model.Producto;
import com.udla.arquitectura.demo.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API REST del catalogo.
 */
@RestController
@RequestMapping("/api/productos") // Ruta base
@CrossOrigin(origins = "*") // Soluciona el problema de CORS para el Frontend
public class ProductoController {

    // 1. SOLUCIÓN: Se inyecta la Interfaz IProductoService
    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    // 3. SOLUCIÓN: Dejamos el GetMapping vacío para que no duplique "/api/productos"
    @GetMapping 
    public List<Producto> listar() {
        // 2. SOLUCIÓN: Usamos el método definido en la Interfaz
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{id}") // La ruta final será /api/productos/1
    public Producto buscar(@PathVariable Long id) {
        // 2. SOLUCIÓN: Este método ya existe en la Interfaz y funciona
        return productoService.buscarPorId(id);
    }
}