package com.projeto.teste.entidades.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.teste.entidades.Order;
import com.projeto.teste.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findall(){
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order Order2 = orderService.findByid(id);
		return ResponseEntity.ok().body(Order2);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		orderService.deleteById(id);
	}
	@PostMapping
	public ResponseEntity<Order> insert(@RequestBody Order Order){
		Order novoOrder = orderService.insert(Order);
		return ResponseEntity.ok().body(novoOrder);
	}
}
