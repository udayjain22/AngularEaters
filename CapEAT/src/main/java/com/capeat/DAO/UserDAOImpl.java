package com.capeat.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capeat.beans.CreditCard;
import com.capeat.beans.UserSignIn;

@Repository
public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;
	UserSignIn us = new UserSignIn();
	CreditCard cd = new CreditCard();

	public UserDAOImpl(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	public UserDAOImpl() {
		super();
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public CreditCard authentication(UserSignIn user) {
		try {
			String sql = ("SELECT * FROM capcafe.employee WHERE eid = \'" + user.getEid() + "\' AND password = \'"
					+ user.getPassword() + "\'");
			us = (UserSignIn) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserSignIn>(UserSignIn.class));
			if (us != null) {
		//		System.out.println(us.getSid());
			
				return getcard();
			
			}
			return cd;
		} catch (EmptyResultDataAccessException e) {
			cd.setStatus("Fail");
			return cd;
		}
	}

	@Override
	public CreditCard getcard() {
		try {
			String sql = ("SELECT * FROM capcafe.carddetails WHERE carddetails.sid=" + us.getSid());
			CreditCard cd = (CreditCard) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<CreditCard>(CreditCard.class));
			cd.setSid(us.getSid());
			cd.setStatus("HasData");
			return cd;
		} catch (EmptyResultDataAccessException e) {
			cd.setSid(us.getSid());
			cd.setStatus("NoData");
			return cd;
		}
	}
}