package com.maestria.arquitectura.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maestria.arquitectura.product_service.dto.ProductoRequest;
import com.maestria.arquitectura.product_service.entity.Producto;
import com.maestria.arquitectura.product_service.exception.ProductoNotFoundException;
import com.maestria.arquitectura.product_service.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // CREATE
    public Producto crearProducto(ProductoRequest request) {

    Producto producto = new Producto(
            request.getNombre(),
            request.getDescripcion(),
            request.getPrecio()
    );

    return productoRepository.save(producto);
    }

    // READ - Todos
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // READ - Por ID
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    // UPDATE
    public Producto actualizarProducto(
        Long id,
        ProductoRequest request) {

        Producto productoExistente = obtenerProductoPorId(id);

        productoExistente.setNombre(request.getNombre());
        productoExistente.setDescripcion(request.getDescripcion());
        productoExistente.setPrecio(request.getPrecio());

        return productoRepository.save(productoExistente);
    }

    // DELETE
    public void eliminarProducto(Long id) {

        Producto producto = obtenerProductoPorId(id);

        productoRepository.delete(producto);
    }
}