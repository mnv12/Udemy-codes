package com.TODO.List.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TODO.List.Entity.Login;
import com.TODO.List.Service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired

	private UserService repo;

	@GetMapping(path="/showLogin")
	public String saveLog(Model model) {

		Login login = new Login();
		
		model.addAttribute("data", login);


		return "LoginUser/Login";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("data") Login login) {

		repo.saveLogin(login);

		return "/User/UserTaskList";
	}

	
	
	
	
}
