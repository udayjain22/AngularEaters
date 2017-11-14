package com.capeat.DAO;

import java.util.List;

import com.capeat.beans.History;
import com.capeat.beans.UserSignIn;



public interface HistoryDAO {

	
	
	//public UserSignin get(int eid);
	public History history(int sid);
	
}