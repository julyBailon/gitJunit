package com.spring.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.producto.entity.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

}
