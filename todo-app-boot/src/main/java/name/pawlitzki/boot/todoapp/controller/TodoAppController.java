package name.pawlitzki.boot.todoapp.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoAppController {

	private static Logger log = LoggerFactory.getLogger(TodoAppController.class);

	@Autowired
	private Environment env;

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
		return "todos";
	}

}
