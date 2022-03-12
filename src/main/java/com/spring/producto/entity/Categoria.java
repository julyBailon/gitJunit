package com.spring.producto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="BRCATEGO")
public class Categoria {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="idCatalogo")
	private Long idCatalogo;
	
	
	//@Column(name="desc_catalogo")
	private String desc_catalogo;
	
	//@Column(name="estatus")
	private String estatus;
	 
	public Long getIdCatalogo() {
		return idCatalogo;
	}

	public void setIdCatalogo(Long idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getDesc_catalogo() {
		return desc_catalogo;
	}

	public void setDesc_catalogo(String desc_catalogo) {
		this.desc_catalogo = desc_catalogo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



}
