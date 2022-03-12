package com.spring.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.producto.feign;
import com.spring.producto.entity.Producto;

import io.swagger.annotations.ApiOperation;
 
@RestController
@RequestMapping("/venta")
public class VentaController {

	
	@Autowired
	private feign feingService;
	

	@ApiOperation(
			value="Cossultar PRoductos",
			notes="trae un arreglo de productos con la Libreria feign"
			
			)
	@GetMapping(path="/producto")
	public ResponseEntity<List<Producto>> GetProductos(){
		
		try {
		
			return new ResponseEntity<>(feingService.getPRoductos(),HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.print(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
}
