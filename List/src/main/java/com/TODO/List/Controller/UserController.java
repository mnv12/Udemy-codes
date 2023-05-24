package com.TODO.List.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.TODO.List.Entity.User;
import com.TODO.List.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/showForm")
	public String show(Model model) {

		User user = new User();
		model.addAttribute("users", user);

		return "/User/TaskForm";

	}

	@GetMapping("/List")
	public String showList(Model model) {
		List<User> user = service.findAll();
//
		//CollectionModel<User> response = CollectionModel.of(user);
//		// creating link for self describing
	//	WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).show(model));

		// create a response
	//	response.add(link.withSelfRel());
	//	model.addAttribute("users", response.getContent());

		model.addAttribute("users", user);
		return "/User/UserTaskList";

	}

	@PostMapping("/userSave")
	public String saveUser(@ModelAttribute("users") User user) {

		service.saveUser(user);

		return "redirect:/user/List";
	}

	@GetMapping("/update")
	public String updatedUser(@RequestParam("userid") Long id, Model model) {

		Optional<User> optional = service.updateUser(id);

		model.addAttribute("users", optional);
		return "/User/TaskForm";
	}

}
