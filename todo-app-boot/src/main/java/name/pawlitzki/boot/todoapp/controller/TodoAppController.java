package name.pawlitzki.boot.todoapp.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import name.pawlitzki.boot.todoapp.model.Todo;
import name.pawlitzki.boot.todoapp.model.TodoNotFoundException;
import name.pawlitzki.boot.todoapp.service.TodoRepo;

@Controller
public class TodoAppController {

	private static Logger log = LoggerFactory.getLogger(TodoAppController.class);

	private final TodoRepo todoRepo;

	@Autowired
	public TodoAppController(TodoRepo todoRepo) {
		this.todoRepo = todoRepo;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("breadcrumbs", Arrays.asList(//
				new Crumb("Home") //
		));
		model.addAttribute("message", "Hello World!!!");
		return "index";
	}

	@GetMapping("/todos")
	public String test(Model model) {
		log.info("Todos");
		model.addAttribute("breadcrumbs", Arrays.asList(//
				new Crumb("/", "Home"), //
				new Crumb("Todos")));

		model.addAttribute("todos", todoRepo.getTodos());
		return "todos";
	}

	@GetMapping("/todos/{todoId}")
	public String todo(@PathVariable Long todoId, Model model) {
		log.info("View Todo # " + todoId);

		Todo todo = todoRepo.getTodo(todoId).orElseThrow(() -> new TodoNotFoundException(todoId));
		model.addAttribute("todo", todo);
		model.addAttribute("breadcrumbs", Arrays.asList(//
				new Crumb("/", "Home"), //
				new Crumb("/todos/", "Todos"), //
				new Crumb("Todo " + todo.getId())));
		return "todo";
	}

	@PostMapping("/todos/{todoId}")
	public String postTodo(@PathVariable Long todoId, @ModelAttribute Todo todo, RedirectAttributes attributes) {
		log.info("change todo " + todoId);
		todoRepo.update(todoId, todo);
		attributes.addFlashAttribute("messages", Arrays.asList("Todo changed"));

		return "redirect:/todos";
	}

}
