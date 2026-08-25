package com.maestria.arquitectura.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maestria.arquitectura.product_service.entity.Producto;
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
