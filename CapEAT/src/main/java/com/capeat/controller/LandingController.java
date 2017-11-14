package com.capeat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capeat.DAO.HistoryDAO;
import com.capeat.DAO.HistoryDAOImpl;
import com.capeat.DAO.UserDAO;
import com.capeat.DAO.UserDAOImpl;
import com.capeat.beans.CardDet;
import com.capeat.beans.History;
import com.capeat.beans.UserSignIn;

@Controller
public class LandingController {
	@Autowired
	UserDAOImpl userDAO;

	@Autowired
	HistoryDAOImpl historyDAO;

	CardDet newCd = new CardDet();

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public @ResponseBody CardDet listAll(@RequestBody UserSignIn user) {
		System.out.println("signing controller");
		CardDet cd = userDAO.authentication(user);
		if (cd == null) {
			newCd.setStatus("Fail");
			return newCd;
		}
		System.out.println(cd.getSid());
		cd.setStatus("Pass");
		return cd;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listAll() {
		System.out.println("Landing controller");
		return "/static/dist/index.html";
	}

	@RequestMapping(value = "/history", method = RequestMethod.POST)
	public @ResponseBody List<History> listAll(@RequestBody String sid) {
		System.out.println("hello history");
		List<History> listHistory = new ArrayList<History>();
		listHistory = historyDAO.historyList(sid);
		System.out.println(listHistory.toString());
		return listHistory;
	}
}
