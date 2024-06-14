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

import com.projeto.teste.entidades.Category;
import com.projeto.teste.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findall(){
		List<Category> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category Category2 = categoryService.findByid(id);
		return ResponseEntity.ok().body(Category2);
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		categoryService.deleteById(id);
	}
	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody Category Category){
		Category novoCategory = categoryService.insert(Category);
		return ResponseEntity.ok().body(novoCategory);
	}
}
