package com.capeat.DAO;

import java.util.List;

import com.capeat.beans.CreditCard;
import com.capeat.beans.UserSignIn;

public interface UserDAO {
	public CreditCard authentication(UserSignIn user);

	public CreditCard getcard();
}
