package com.projeto.teste.entidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.teste.entidades.OrderItem;
import com.projeto.teste.entidades.pk.OrderItemPk;

public interface OrdemItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
