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

import com.projeto.teste.entidades.Produtos;
import com.projeto.teste.services.ProdutosService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosResources {
	
	@Autowired
	private ProdutosService produtosService;
	
	
	@GetMapping
	public ResponseEntity<List<Produtos>> findall(){
		List<Produtos> list = produtosService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Produtos> findById(@PathVariable Long id){
		Produtos Produtos2 = produtosService.findByid(id);
		return ResponseEntity.ok().body(Produtos2);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		produtosService.deleteById(id);
	}
	@PostMapping
	public ResponseEntity<Produtos> insert(@RequestBody Produtos Produtos){
		Produtos novoProdutos = produtosService.insert(Produtos);
		return ResponseEntity.ok().body(novoProdutos);
	}
}
