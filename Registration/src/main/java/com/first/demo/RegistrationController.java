package com.first.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.first.demo.subpart.UserRepo;

@Controller
public class RegistrationController {
	@Autowired
	UserRepo repo;
	@RequestMapping("/hi")
	public String register(){
		return "registration";
	}
	@RequestMapping("/UserDetails")
	public ModelAndView userinfo(User reg){
		repo.save(reg);
		System.out.println(reg.getName());
		ModelAndView mv=new ModelAndView("UserDetails");
		mv.addObject("regobj",reg);
		return mv;
	}
}
