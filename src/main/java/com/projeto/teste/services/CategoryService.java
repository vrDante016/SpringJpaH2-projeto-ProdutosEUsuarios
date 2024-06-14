package com.projeto.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.teste.entidades.Category;
import com.projeto.teste.entidades.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	 
	public Category findByid(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	@Transactional
	public void deleteById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id); 
		if(obj.isPresent()) {
			categoryRepository.deleteById(id);;
		}
		
	}
	@Transactional
	public Category insert(Category Category) {
		return categoryRepository.save(Category);
		
	}
}
