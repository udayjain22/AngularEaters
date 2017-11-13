package com.capeat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capeat.DAO.OrdersDAOImpl;
import com.capeat.DAO.UserDAO;
import com.capeat.DAO.UserDAOImpl;
import com.capeat.beans.Orders;
import com.capeat.beans.UserSignIn;

@Controller
public class LandingController {
	@Autowired
	UserDAOImpl userDAO;
	
	@Autowired
	OrdersDAOImpl ordersDAO;
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody List<UserSignIn> listAll(@RequestBody UserSignIn user) {
		System.out.println("signing controller");
		List<UserSignIn> listUser = new ArrayList<UserSignIn>();
		listUser = userDAO.authentication(user);
		System.out.println(user.toString());
		return listUser;
	}

@RequestMapping(value="/home", method = RequestMethod.GET)
public String listAll() {
	System.out.println("Landing controller");
	return "/static/dist/index.html";
}

@RequestMapping(value="/history",method=RequestMethod.POST)
public @ResponseBody List<Orders> listAll(@RequestBody String eid){
	System.out.println("hello history");
	List<Orders> listArtist = new ArrayList<Orders>();
	listArtist = ordersDAO.historyList(eid);
	System.out.println(listArtist.toString());
	return listArtist;
}
}
