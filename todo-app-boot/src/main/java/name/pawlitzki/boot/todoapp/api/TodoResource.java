package name.pawlitzki.boot.todoapp.api;

import name.pawlitzki.boot.todoapp.model.Todo;

public class TodoResource {

	private final Todo todo;

	public TodoResource(Todo todo) {
		this.todo = todo;
	}

	public Long getId() {
		return todo.getId();
	}

	public String getText() {
		return todo.getText();
	}

	public boolean isDone() {
		return todo.isDone();
	}

}
