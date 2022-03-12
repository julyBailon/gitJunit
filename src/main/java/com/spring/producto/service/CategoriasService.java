package com.spring.producto.service;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.producto.entity.Categoria;
import com.spring.producto.repository.CategoriasRepository;

@Service
public class CategoriasService {
	private CategoriasRepository categoriasRepository;
	

	@Autowired
	public CategoriasService(CategoriasRepository categoriasRepository) {
		this.categoriasRepository=categoriasRepository;
	}
	
	public List<Categoria> consultarCategorias() {

		 return categoriasRepository.findAll();
		  
	}

	
	public Optional<Categoria> findallbyCategoria(long id){
		return categoriasRepository.findById(id);
	}
	
	
	public ResponseEntity<Categoria>  guardar(Categoria categoria) {
		Categoria obj=categoriasRepository.save(categoria);
		
		return new ResponseEntity<Categoria>(obj,HttpStatus.OK);
	}



	public   Categoria  actualizarCategoria(Long id,  Categoria categoria) {
		Categoria cat = categoriasRepository.findById(id).get();
		cat.setIdCatalogo(categoria.getIdCatalogo());
		cat.setDesc_catalogo(categoria.getDesc_catalogo());
		return categoriasRepository.save(categoria);
	}

	
	public void eliminarCategoria(Long numCategoria) {
		 
		     categoriasRepository.deleteById(numCategoria);
				
	}	

	

	
	
	

}
