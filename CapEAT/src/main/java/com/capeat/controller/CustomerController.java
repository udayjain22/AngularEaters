package com.capeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capeat.DAO.UserDAOImpl;
import com.capeat.beans.UserSignIn;


@Controller
public class CustomerController {
	
	@Autowired
	UserDAOImpl udi;

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	

public  String listAll() {
    //List<UserSignIn> uslist = udi.listAll();
    return "/static/dist/index.html";
//	private String signin() {
//		// TODO Auto-generated method stub
//		return "/static/sample.html/";
	}

}
