package com.todo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.domain.Todo;
import com.todo.services.TodoService;

@RestController
@RequestMapping(value="/todo")
public class TodoResource {

	@Autowired
	private TodoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Todo> find(@PathVariable Integer id) {
		Todo obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
