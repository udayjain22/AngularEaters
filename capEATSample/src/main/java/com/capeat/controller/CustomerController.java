package com.capeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	private String signin() {
		// TODO Auto-generated method stub
		return "/static/sample.html/";
	}

}
