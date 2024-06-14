package com.projeto.teste.entidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entidades.Order;

public interface OrderRepository  extends JpaRepository<Order, Long> {

}
