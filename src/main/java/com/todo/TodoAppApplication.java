package com.todo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo.domain.Todo;
import com.todo.repositories.TodoRepository;
import com.todo.services.crypt.Encrypt;

@SpringBootApplication

public class TodoAppApplication implements CommandLineRunner {
	
	@Autowired
	private TodoRepository todo;
	@Autowired
	private Encrypt encrypt;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Todo todo1 = new Todo(null, encrypt.crypt("testando texto", 3));
		Todo todo2 = new Todo(null, "Atividade de NodeJS");

		todo.saveAll(Arrays.asList(todo1, todo2));
	}
}
