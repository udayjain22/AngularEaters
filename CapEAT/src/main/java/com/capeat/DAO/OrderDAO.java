package com.capeat.DAO;

import java.util.List;

import com.capeat.beans.CreditCard;
import com.capeat.beans.Order;

public interface OrderDAO {

	public int insertorder (List<Order> o, Double amount, Integer sid);
	public void insertCredit(CreditCard c, Integer sid);
	public void deleteCredit(Integer sid);
}
