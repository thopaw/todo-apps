package name.pawlitzki.boot.todoapp.service;

import name.pawlitzki.boot.todoapp.model.Todo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TodoRepo {

	Mono<Todo> getTodo(Long id);

	Flux<Todo> getTodos();

	Mono<Void> save(Todo todo);

}
