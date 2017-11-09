package com.capeat.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capeat.beans.UserSignIn;


@Repository
public class UserDAOImpl implements UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDAOImpl(DataSource ds){
		jdbcTemplate = new JdbcTemplate(ds);
	}


//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}


	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public List<UserSignIn> authentication(UserSignIn user) {
		System.out.println(user.getEid());
		System.out.println(user.getPassword());
		String sql=("SELECT * FROM capcafe.employee WHERE eid = \'" + user.getEid() + "\' AND password = \'" + user.getPassword() + "\'");
		
				List<UserSignIn> uslist=jdbcTemplate.query (sql, new RowMapper<UserSignIn>(){
					public UserSignIn mapRow(ResultSet rs,int nRows)throws SQLException{
						UserSignIn us=new UserSignIn();						
						us.setEid(rs.getString("eid"));
						us.setPassword(rs.getString("password"));		
						return us;						
					}
				});
				return uslist;
		}
	
}
