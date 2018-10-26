package com.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.domain.Todo;
import com.todo.repositories.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repo;

	public Todo buscar(Integer id) {
		Todo obj = repo.findById(id).orElse(null);
		return obj;
	}
	public List<Todo> buscarTodos() {
		return this.repo.findAll();
	}
	
	public Todo inserir(Todo todo) {
		
		Todo todoInserido = this.repo.save(todo);
		return todoInserido;
	}
	
}
