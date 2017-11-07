package com.capeat.DAO;

import java.util.List;

import com.capeat.beans.UserSignIn;



public interface UserDAO {

	
	
	//public UserSignin get(int eid);
	public List<UserSignIn> listAll();
	
}
