package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.teste.entidades.Order;
import com.projeto.teste.entidades.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	 
	public Order findByid(Long id) {
		return orderRepository.findById(id).orElse(null);
	}
	@Transactional
	public void deleteById(Long id) {
		Optional<Order> obj = orderRepository.findById(id); 
		if(obj.isPresent()) {
			orderRepository.deleteById(id);;
		}
		
	}
	@Transactional
	public Order insert(Order order) {
		return orderRepository.save(order);
	}
}
