package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.domain.Categoria;
import com.bookstore.bookstore.repositories.CategoriaRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		java.util.Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}
