package com.spring.producto.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="BRPRODUC")
public class Producto {
	
	@Id
	@Column(name="id_pro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pro;
	
	@Column(name="desc_pro")
	private String desc_pro;
	
	@Column(name="estatus_pro")
	private String estatus_pro;

	@Column(name="tipo_producto")
	private Long tipo_producto;
	
	@Column(name="fecha_registro")
	private Date fecha_registro;

	public Long getId_pro() {
		return id_pro;
	}

	public void setId_pro(Long id_pro) {
		this.id_pro = id_pro;
	}

	public String getDesc_pro() {
		return desc_pro;
	}

	public void setDesc_pro(String desc_pro) {
		this.desc_pro = desc_pro;
	}

	public String getEstatus_pro() {
		return estatus_pro;
	}

	public void setEstatus_pro(String estatus_pro) {
		this.estatus_pro = estatus_pro;
	}

	public Long getTipo_producto() {
		return tipo_producto;
	}

	public void setTipo_producto(Long tipo_producto) {
		this.tipo_producto = tipo_producto;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	 	

}
