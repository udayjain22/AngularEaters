package com.capeat.DAO;

import java.util.List;
import com.capeat.beans.CardDet;
import com.capeat.beans.UserSignIn;

public interface UserDAO {
	public CardDet authentication(UserSignIn user);

	public CardDet getcard();
}
