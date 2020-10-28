package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.web.controller.SessionController;
import com.web.model.User;
import com.web.util.ConnectionUtil;

public class UserDao implements DaoContract<User, Integer>{

	@Override
	public List<User> findAll() {
		List<User> users = new LinkedList<>();
		String sql = "select * from employee_re.ers_users";
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				users.add(new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), rs.getInt("user_role_id")));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findByUsername(String name) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement check = conn.prepareStatement("select * from employee_re.ers_users where ers_username=?");
			check.setString(1, name);
			ResultSet res = check.executeQuery();
			if(res.next())
			{
				return new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User LoginCheck(String name, String password) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			PreparedStatement check = conn.prepareStatement("select * from employee_re.ers_users where ers_username=? and ers_password=?");
			check.setString(1, name);
			check.setString(2, password);
			ResultSet res = check.executeQuery();
			if(res.next())
			{
				return new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7));
				
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
