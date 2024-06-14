package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.teste.entidades.Produtos;
import com.projeto.teste.entidades.repository.ProdutosRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	
	public List<Produtos> findAll(){
		return produtosRepository.findAll();
	}
	 
	public Produtos findByid(Long id) {
		return produtosRepository.findById(id).orElse(null);
	}
	@Transactional
	public void deleteById(Long id) {
		Optional<Produtos> obj = produtosRepository.findById(id); 
		if(obj.isPresent()) {
			produtosRepository.deleteById(id);;
		}
		
	}
	@Transactional
	public Produtos insert(Produtos produtos) {
		return produtosRepository.save(produtos);
	}
}
