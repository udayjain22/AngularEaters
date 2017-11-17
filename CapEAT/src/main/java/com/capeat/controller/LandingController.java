package com.capeat.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capeat.DAO.HistoryDAO;
import com.capeat.DAO.HistoryDAOImpl;
import com.capeat.DAO.OrderDAOImpl;
import com.capeat.DAO.UserDAO;
import com.capeat.DAO.UserDAOImpl;
import com.capeat.beans.*;

@Controller
public class LandingController {
	@Autowired
	UserDAOImpl userDAO;

	@Autowired
	HistoryDAOImpl historyDAO;
	
	@Autowired
	OrderDAOImpl orderDAO;

	CreditCard newCd = new CreditCard();

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody CreditCard listAll(@RequestBody UserSignIn user) {
	//	System.out.println("signing controller");
		CreditCard cd = userDAO.authentication(user);		
	//	System.out.println(cd.getSid());
		return cd;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listAll() {
	//	System.out.println("Landing controller");
		return "/static/dist/index.html";
	}

	@RequestMapping(value = "/history", method = RequestMethod.POST)
	public @ResponseBody List<History> listAll(@RequestBody String sid) {
	//	System.out.println("hello history");
		List<History> listHistory = new ArrayList<History>();
		listHistory = historyDAO.historyList(sid);
	//	System.out.println(listHistory.toString());
		return listHistory;
	}
	
	@RequestMapping(value="/makepayment",method=RequestMethod.POST)
	   public @ResponseBody  int listAll(@RequestBody Wrapper w){
		List<Order> credit = new ArrayList<>();
		int orderid = orderDAO.insertorder(w.getOrder(), Double.parseDouble(w.getAmount()), Integer.parseInt(w.getSid()));
        if(w.getCreditCard().getDecision().equals("insert") || w.getCreditCard().getDecision().equals("update")) {
        		orderDAO.insertCredit(w.getCreditCard(),Integer.parseInt(w.getSid()));
        }
        if (w.getCreditCard().getDecision().equals("delete")) {
            orderDAO.deleteCredit(Integer.parseInt(w.getSid()));
		}	
	       return orderid;
	       
	   }
}
