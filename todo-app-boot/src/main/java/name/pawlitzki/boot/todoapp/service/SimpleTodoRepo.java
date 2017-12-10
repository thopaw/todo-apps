package name.pawlitzki.boot.todoapp.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import name.pawlitzki.boot.todoapp.model.Todo;

@Repository
public class SimpleTodoRepo implements TodoRepo {
	private static final Logger log = LoggerFactory.getLogger(SimpleTodoRepo.class);

	private TreeMap<Long, Todo> todos = new TreeMap<Long, Todo>();

	public SimpleTodoRepo() {
		log.info("add default todos");

		save(new Todo(1L, "Simple Todo 1", false));
		save(new Todo(2L, "buy food for weekend", true));
		save(new Todo(3L, "clean the kittchen", false));
	}

	@Override
	public Optional<Todo> getTodo(Long id) {
		return Optional.ofNullable(todos.get(id));
	}

	@Override
	public List<Todo> getTodos() {
		return Collections.unmodifiableList(todos.values().stream().collect(Collectors.toList()));
	}

	@Override
	public void save(Todo todo) {
		log.info("Save TODO");
		Assert.notNull(todo, "todo may not be null");
		todos.put(todo.getId(), todo);
	}
}