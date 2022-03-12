package com.spring.categoria;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.producto.controller.CategoriasController;
import com.spring.producto.entity.Categoria;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
 

@SpringBootTest
public class CategoriaControllerTest {
	
    @Autowired
    private CategoriasController categoriasController;

	
 
    @Test 
    public void TodasCategoriasTest(){
        ResponseEntity<List<Categoria>> categorias;
        categorias = categoriasController.consultaCategorias();
        assertEquals(HttpStatus.OK.toString(),categorias.getStatusCode().toString());
    }

   
	@Test
    public void BuscarCategoriPorIDTest(){
        ResponseEntity<Categoria> categoria;
        Long id = 1L;
        categoria = categoriasController.ConsultaCategoriaPorId(id);
        assertEquals(HttpStatus.OK.toString(),categoria.getStatusCode().toString());
         
    }

    
    
    @Test 
    public void createCategoriaTest(){
    	
    	 
        Categoria categoria= new  Categoria() ;
        
        categoria.setDesc_catalogo("Hielera");
        categoria.setEstatus("A");
         	 
        
        ResponseEntity<Categoria> categoriaResponse = categoriasController.guardarCategoria(categoria);
        assertEquals(HttpStatus.CREATED, categoriaResponse.getStatusCode());
        assertNotNull(categoriaResponse.getBody().getIdCatalogo());
    }

    @Test 
    public void deleteCategoriaTest(){
            long id=1;
    	 assertEquals(HttpStatus.ACCEPTED,categoriasController.EliminarCategoria(id).getStatusCode());
    }

    @Test 
    public void updateCategoriaTest(){
         
    	long id=2;
        Categoria categoria= new  Categoria() ;
        
        categoria.setDesc_catalogo("Hielera");
        categoria.setEstatus("A");
        categoria.setIdCatalogo(id);
		
        
    	assertEquals(HttpStatus.ACCEPTED,categoriasController.ActualizarCategoria(id,categoria ).getStatusCode());
    }
	
	
}
