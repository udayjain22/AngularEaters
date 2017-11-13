package com.capeat.DAO;

import java.util.List;

import com.capeat.beans.Orders;
import com.capeat.beans.UserSignIn;



public interface OrdersDAO {

	
	
	//public UserSignin get(int eid);
	public List<Orders> historyList(String eid);
	
}