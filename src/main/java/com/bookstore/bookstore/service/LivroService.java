package com.bookstore.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.domain.Livro;
import com.bookstore.bookstore.repositories.LivroRepository;
import com.bookstore.bookstore.service.exceptions.ObjectNotFoundException;


@Service
public class LivroService {
	
  @Autowired
  private LivroRepository repository;

  @Autowired
  private CategoriaService categoriaService;
  
  public Livro findById(Integer id) {
	  java.util.Optional<Livro> obj = repository.findById(id);
	  return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id + ", Tipo: " + Livro.class.getName()));
  }

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllCategoria(id_cat);
	}
}
