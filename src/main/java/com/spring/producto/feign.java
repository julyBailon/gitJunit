package com.spring.producto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.producto.entity.Producto;

@FeignClient(value="feignVentas",url="http://localhost:8080")
public interface feign {
	
	@GetMapping(path="/producto/all")
	List<Producto> getPRoductos();

}
