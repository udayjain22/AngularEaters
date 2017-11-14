package com.capeat.DAO;

import java.util.List;

import com.capeat.beans.History;
import com.capeat.beans.UserSignIn;



public interface HistoryDAO {

	
	

	public List<History> historyList(String eid);
	
}