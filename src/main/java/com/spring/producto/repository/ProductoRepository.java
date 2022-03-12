package com.spring.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.producto.entity.Producto;

public interface ProductoRepository  extends JpaRepository<Producto, Long>{

}
