package name.pawlitzki.boot.todoapp.service;

import java.util.TreeMap;

import name.pawlitzki.boot.todoapp.model.Todo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SimpleTodoRepo implements TodoRepo {

	private TreeMap<Long, Todo> todos = new TreeMap<Long, Todo>();

	@Override
	public Mono<Todo> getTodo(Long id) {
		return null;
	}

	@Override
	public Flux<Todo> getTodos() {
		return null;
	}

	@Override
	public Mono<Void> save(Todo todo) {
		return Mono.empty();
	}
}