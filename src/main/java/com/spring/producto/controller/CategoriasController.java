package com.spring.producto.controller;
 
import java.util.List;
import java.util.Optional;

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

import com.spring.producto.entity.Categoria;
import com.spring.producto.service.CategoriasService;

@RestController
@RequestMapping("/categoria")
public class CategoriasController {
	
CategoriasService categoriasService;
	
	public CategoriasController (CategoriasService categoriasService) {
		this.categoriasService=categoriasService;
		
	}
	
	@GetMapping(value = "/all") 
	public ResponseEntity<List<Categoria>>  consultaCategorias(){
		
		try {
            List<Categoria> categorias = categoriasService.consultarCategorias();
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		
	 	
	}

	@GetMapping("{id}")
	public ResponseEntity<Categoria> ConsultaCategoriaPorId(@PathVariable(value="id") Long id){
		
		  try {
	            Optional<Categoria> categoria = categoriasService.findallbyCategoria(id);
	            if (categoria.isPresent())
	                return new ResponseEntity<>(categoria.get(), HttpStatus.OK);
	            else
	                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }

		   
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria){
		
		try {
			 
			 return  categoriasService.guardar(categoria);
			
			  
		} catch (Exception e) {
		
			System.out.print(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}	
	}
	
	@DeleteMapping(value="/delete/{id}")
	public  ResponseEntity<Categoria> EliminarCategoria(@PathVariable(value = "id") Long id) {
		
		try {
            categoriasService.eliminarCategoria(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
	}
	
	
	 
	 @PutMapping(value="/update/{id}")
	public ResponseEntity<Categoria> ActualizarCategoria(@PathVariable(value = "id") Long id, @RequestBody Categoria categoria) {
		   
		try {
	             Categoria categoriaUpdated = categoriasService.actualizarCategoria(id, categoria);
	            return new ResponseEntity<>(categoriaUpdated, HttpStatus.ACCEPTED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }

	}
	

}
