package name.pawlitzki.boot.todoapp.service;

import java.util.List;
import java.util.Optional;

import name.pawlitzki.boot.todoapp.model.Todo;

public interface TodoRepo {

	Optional<Todo> getTodo(Long id);

	List<Todo> getTodos();

	void save(Todo todo);

	void update(Long todoId, Todo todo);

}
