package com.training.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.springmvc.model.User;
import com.training.springmvc.repository.UserRepository;

@RequestMapping("/")
@Controller
public class HomeController {
	
	@Autowired
	UserRepository repository;

	@RequestMapping("/")
	public String displayGreeting(ModelMap model) {
		model.addAttribute("message", "hello from homecontroller");
		return "home";
	}
	
	@RequestMapping("/message")
	public String displayMessage(ModelMap model) {
		model.addAttribute("value", "this is a special message");
		return "message";
	}
	
	@RequestMapping(value="/users", produces="application/json")
	@ResponseBody
	public List<User> getUsers() {
		List<User> users = repository.findAll();
		return users;
	}
}
