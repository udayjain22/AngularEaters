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
	
	private JdbcTemplate jt;
	
	public UserDAOImpl(DataSource ds){
		jt=new JdbcTemplate(ds);
	}
	
	public List<UserSignIn> listAll() {
		String sql="select * from \"employee\"";
		List<UserSignIn> uslist=jt.query(sql, new RowMapper<UserSignIn>(){
			
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
