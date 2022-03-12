package com.spring.producto.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.spring.producto.entity.Producto;
import com.spring.producto.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	ProductoService productoService;
	
	public ProductoController(ProductoService productoService) {
		this.productoService=productoService;
	}
	
	
   
	@GetMapping(value = "/all") 
	public List<Producto> consultaProductos(){
		return productoService.consultarProductos();
	}
	
	/*
	@GetMapping("{id}")
	public ResponseEntity<List<Producto>> ConsultaProductoPorId(@PathVariable("id") Long id){
		
		return ResponseEntity.ok(productoService.findallbyProducto(id));
	}
	*/
	
	@GetMapping("{id}")
	public Producto ConsultaUnProductoPorId(@PathVariable("id") Long id){
		
		Producto p=productoService.consultarProducto(id);
		return p;
	}
	
	
	@PostMapping(value = "/save")
	public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
		
		try {
			 
			 return  productoService.guardarProducto(producto);
			
			  
		} catch (Exception e) {
		 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		}
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<Map<String,Boolean>> EliminarProducto(@PathVariable("id") Long id){
		
		//productoService.eliminarCategoria(id);
		
		Map<String,Boolean> respuesta = new HashMap<>();
		respuesta.put("Eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Producto> ActualizarProducto(@RequestBody Producto producto){
		try {
			
			Producto registroProducto =productoService.actualizarProducto(producto);
			
			return ResponseEntity.created(new URI("/producto/" + registroProducto.getId_pro())).body(registroProducto);
			
		} catch (Exception e) {
			
			System.out.print(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
	

	
	
}
