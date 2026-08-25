package com.maestria.arquitectura.product_service.exception;

public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(Long id)
    {
        super("Producto no encontrado con id:" + id);
    }
}
