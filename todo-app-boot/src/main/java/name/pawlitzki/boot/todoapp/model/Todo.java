package name.pawlitzki.boot.todoapp.model;

import org.springframework.util.Assert;

public class Todo {

	private final Long id;
	private final String text;
	private final boolean done;

	public Todo(Long id, String text, boolean done) {
		super();
		Assert.notNull(id, "todo.id may not be null");
		this.id = id;
		this.text = text;
		this.done = done;
	}

	public Long getId() {
		return id;
	}

	public boolean isDone() {
		return done;
	}

	public String getText() {
		return text;
	}

}
