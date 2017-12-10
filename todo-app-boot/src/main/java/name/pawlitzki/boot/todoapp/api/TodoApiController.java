package name.pawlitzki.boot.todoapp.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import name.pawlitzki.boot.todoapp.service.TodoRepo;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {

	private final TodoRepo repo;

	@Autowired
	public TodoApiController(TodoRepo repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/")
	public HttpEntity<List<TodoResource>> list() {
		return new ResponseEntity<List<TodoResource>>(repo.getTodos().stream().map((todo) -> {
			return new TodoResource(todo);
		}).collect(Collectors.toList()), HttpStatus.OK);

	}

}
