package com.todo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.domain.Todo;
import com.todo.services.TodoService;
import com.todo.services.crypt.Encrypt;
import com.todo.services.crypt.Exhange;

@RestController
@RequestMapping(value="/todo")
public class TodoResource {

	@Autowired
	private TodoService service;
	@Autowired
	private Encrypt encrypt;
	@Autowired
	private Exhange exchange;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Todo> find(@PathVariable Integer id) {
		Todo obj = service.buscar(id);
		String textoCifrado = obj.getNome();
		String cifraTrocada = exchange.exchangeBack(textoCifrado);
		int cifra = cifraTrocada.length();
		obj.setNome(encrypt.decrypt(cifraTrocada, cifra));
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	List<Todo> all() {
		List<Todo> myList = new ArrayList<Todo>();
		myList = service.buscarTodos();
		return  myList;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	Todo newTodo(@RequestBody Todo newTodo) {
		String textoEncriptado = newTodo.getNome();
		int cifra = textoEncriptado.length();
		String cifradoSemtroca = encrypt.crypt(textoEncriptado, cifra);

		newTodo.setNome(exchange.exchange(cifradoSemtroca));
		return service.inserir(newTodo);
	}
}
