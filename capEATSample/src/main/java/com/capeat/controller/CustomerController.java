package com.capeat.controller;


@Controller
public class CustomerController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	private String signin() {
		// TODO Auto-generated method stub
		return "/static/sample.html/";
	}

}
