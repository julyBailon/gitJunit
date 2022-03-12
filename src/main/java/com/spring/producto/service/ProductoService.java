package com.spring.producto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import com.spring.producto.entity.Producto;
import com.spring.producto.repository.ProductoRepository;
 
@Service
public class ProductoService {
	 
		private ProductoRepository productoRepository;
		
		@Autowired
		public ProductoService(ProductoRepository productoRepository) {
			this.productoRepository=productoRepository;
		}
		
		public List<Producto> consultarProductos() {
			return productoRepository.findAll();
		}
		
		public  Producto consultarProducto(Long id) {
			return  productoRepository.findById(id).get();
		}
		
		
		public ResponseEntity<Producto>  guardarProducto(Producto producto) {
			Producto obj=productoRepository.save(producto);
			
			return new ResponseEntity<Producto>(obj,HttpStatus.OK);
		}

		public List<Producto> findallbyProducto(long id){
			List<Producto> categoriaRespuesta=new ArrayList<>();
			List<Producto> categoria=productoRepository.findAll();
			for(int i=0;i<categoria.size();i++) {
				if(categoria.get(i).getId_pro()==id) {
					categoriaRespuesta.add(categoria.get(i));
				}
				
			}
			
			return categoriaRespuesta;
		}
		
		
		
		public <S extends Producto> S actualizarProducto(S entity) {
			Producto cat =new Producto();
			cat.setId_pro(entity.getId_pro());
			cat.setDesc_pro(entity.getDesc_pro());
			return productoRepository.save(entity);
		}
		
		public void eliminarCategoria(Producto p) {
		
			//=productoRepository.findById(numCategoria).get();
			
			 productoRepository.delete(p);
			/*List<Producto> categoriaRespuesta=new ArrayList<>();
			categoriaRespuesta=findallbyProducto(numCategoria);
			Producto cat = new Producto();
			
			for (Producto categoria : categoriaRespuesta) {
				cat=categoria;
			
				 if(cat != null){
					 productoRepository.delete(cat);
					}
			}
			
			*/
			 	 
		}	

		

		
		
		

	}

	

