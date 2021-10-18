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
	  return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
  }

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getNome_autor());
	}
}
