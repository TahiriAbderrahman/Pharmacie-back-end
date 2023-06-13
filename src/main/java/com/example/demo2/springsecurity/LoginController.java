package com.example.demo2.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.repository.UserRepository;



@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/login");
		return modelAndView;
	}
}
