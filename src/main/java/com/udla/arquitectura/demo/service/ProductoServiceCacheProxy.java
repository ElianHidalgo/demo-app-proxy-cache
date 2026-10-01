package com.udla.arquitectura.demo.service;

import com.udla.arquitectura.demo.model.Producto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Primary // Hace que Spring inyecte esta clase en el Controller
public class ProductoServiceCacheProxy implements IProductoService {

    private final ProductoServiceImpl servicioReal;
    private List<Producto> cacheProductos;

    public ProductoServiceCacheProxy(ProductoServiceImpl servicioReal) {
        this.servicioReal = servicioReal;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        if (cacheProductos == null || cacheProductos.isEmpty()) {
            System.out.println("Proxy: Caché vacía. Delegando al servicio real...");
            cacheProductos = servicioReal.obtenerTodosLosProductos();
        } else {
            System.out.println("Proxy: Retornando productos desde la caché...");
        }
        return cacheProductos;
    }

    @Override
    public Producto buscarPorId(Long id) {
        // Delegamos directamente sin caché para la búsqueda individual
        return servicioReal.buscarPorId(id);
    }

    public void limpiarCache() {
        this.cacheProductos = null;
    }
}