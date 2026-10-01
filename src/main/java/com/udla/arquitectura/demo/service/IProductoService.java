package com.udla.arquitectura.demo.service;

import com.udla.arquitectura.demo.model.Producto;
import java.util.List;

public interface IProductoService {
    List<Producto> obtenerTodosLosProductos();
    Producto buscarPorId(Long id); // Agregado para solucionar el error del Controller
}