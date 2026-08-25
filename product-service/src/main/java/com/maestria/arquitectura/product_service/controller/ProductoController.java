package com.maestria.arquitectura.product_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maestria.arquitectura.product_service.dto.ProductoRequest;
import com.maestria.arquitectura.product_service.entity.Producto;
import com.maestria.arquitectura.product_service.service.ProductoService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Producto> crearProducto(
            @Valid @RequestBody ProductoRequest productoRequest) {

        Producto productoCreado =
                productoService.crearProducto(productoRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productoCreado);
    }

    // READ - Todos
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {

        return ResponseEntity.ok(
                productoService.listarProductos()
        );
    }

    // READ - Por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productoService.obtenerProductoPorId(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequest productoRequest) {

        return ResponseEntity.ok(
                productoService.actualizarProducto(id, productoRequest)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(
            @PathVariable Long id) {

        productoService.eliminarProducto(id);

        return ResponseEntity.noContent().build();
    }
}