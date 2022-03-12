package com.spring.producto.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.producto.entity.Producto;

@SpringBootTest
public class ProductosControllerTest {
	
	@Autowired
	ProductoController productoController;
	

	@Test
	public void obtenerProductos() {
		List<Producto> producto;
		producto=productoController.consultaProductos();
		
		assertNotNull(producto);
		
	}
	
	@Test
	public void agregarProducto() {
	Producto	producto= new Producto();
		 long tipo=4;
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);

		 String sDate1="31/12/1998";
		 Date date1 = null;
		try {
			date1 = (Date) formatter.parse(sDate1);
		} catch (ParseException e) {
		 
		}
		 
		 
		 producto.setDesc_pro("Hielera");
		 producto.setTipo_producto(tipo);
		 producto.setEstatus_pro("A");
		 producto.setFecha_registro(date1);
		  
		 assertNotNull(productoController.guardarProducto(producto));
			
	
	}

 
	@Test
	public void Actualizar() {
	Producto	producto= new Producto();
		 long tipo=4;
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH);

		 String sDate1="31/12/1998";
		 Date date1 = null;
		try {
			date1 = (Date) formatter.parse(sDate1);
		} catch (ParseException e) {
		 
		}
		 
		 
		 producto.setDesc_pro("Hielera");
		 producto.setTipo_producto(tipo);
		 producto.setEstatus_pro("A");
		 producto.setFecha_registro(date1);
		  
		 assertNotNull(productoController.ActualizarProducto(producto));
			
	}
	
	
	@Test
	public void EliminarProducto() {
		long id=5;
		productoController.EliminarProducto(id);
		assertEquals(Optional.empty(), productoController.ConsultaUnProductoPorId(id));
		
	}

	

	


}
