package name.pawlitzki.boot.todoapp.model;

public class TodoNotFoundException extends RuntimeException {

	private final Long id;

	public TodoNotFoundException(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
