package com.capeat.DAO;

import java.util.List;

import com.capeat.beans.UserSignIn;



public interface UserDAO {

	public List<UserSignIn> authentication(UserSignIn user);
	
}
