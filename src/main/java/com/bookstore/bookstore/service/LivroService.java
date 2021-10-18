package com.bookstore.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.domain.Livro;
import com.bookstore.bookstore.repositories.LivroRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFoundException;


@Service
public class LivroService {
	
  @Autowired
  private LivroRepository repository;
  
  public Livro findById(Integer id) {
	  java.util.Optional<Livro> obj = repository.findById(id);
	  return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id + ", Tipo: " + Livro.class.getName()));
  }
}
