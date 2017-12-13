package name.pawlitzki.boot.todoapp.model;

import org.springframework.util.Assert;

public class Todo {

	private Long id;
	private String text;
	private boolean done;

	public Todo() {

	}

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

	public void setText(String text) {
		this.text = text;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
