package com.web.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.web.model.Reimburse;
import com.web.model.User;
import com.web.util.ConnectionUtil;

public class ReimbursementDao implements DaoContract<Reimburse, Integer>{

	@Override
	public List<Reimburse> findAll() {
		List<Reimburse> reimbs = new LinkedList<Reimburse>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			LocalDateTime temp = null; 
			PreparedStatement check = conn.prepareStatement("select * from employee_re.reimbursementview2 where ers_users_id=?");
			ResultSet res = check.executeQuery();
			while(res.next())
			{
				if(res.getTimestamp("reimb_resolved") != null)
					temp = res.getTimestamp("reimb_resolved").toLocalDateTime();
					
				reimbs.add(new Reimburse(res.getInt(1), res.getBigDecimal(2), res.getTimestamp("reimb_submitted").toLocalDateTime(), 
						temp, 
						res.getString("reimb_description"), res.getInt("ers_users_id"),
						res.getString("reimb_status"), res.getString("reimb_type_id")));
			}
			res.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
		
	}
	
	
	public List<Reimburse> findAllByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimburse findById(Integer i) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			LocalDateTime temp = null; 
			PreparedStatement check = conn.prepareStatement("select * from employee_re.reimbursementview2 where reimb_id=?");
			check.setInt(1, i);
			ResultSet res = check.executeQuery();
			if(res.next())
			{
				if(res.getTimestamp("reimb_resolved") != null)
					temp = res.getTimestamp("reimb_resolved").toLocalDateTime();
					
				return new Reimburse(res.getInt(1), res.getBigDecimal(2), res.getTimestamp("reimb_submitted").toLocalDateTime(), 
						temp, 
						res.getString("reimb_description"), res.getInt("ers_users_id"),
						res.getInt("reimb_status_id"), res.getInt("reimb_type_id"));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Reimburse> findByUsrId(Integer i) {
		List<Reimburse> reimbs = new LinkedList<Reimburse>();
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			LocalDateTime temp = null; 
			PreparedStatement check = conn.prepareStatement("select * from employee_re.reimbursementview2 where ers_users_id=?");
			check.setInt(1, i);
			ResultSet res = check.executeQuery();
			while(res.next())
			{
				if(res.getTimestamp("reimb_resolved") != null)
					temp = res.getTimestamp("reimb_resolved").toLocalDateTime();
					
				reimbs.add(new Reimburse(res.getInt(1), res.getBigDecimal(2), res.getTimestamp("reimb_submitted").toLocalDateTime(), 
						temp, 
						res.getString("reimb_description"), res.getInt("ers_users_id"),
						res.getString("reimb_status"), res.getString("reimb_type")));
			}
			res.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public int update(Reimburse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create(Reimburse t) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			Date date = new Date();
			PreparedStatement add = conn.prepareStatement("insert into employee_re.ers_reimbursement (reimb_amount, "
					+ " reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) "
					+ "values (?, ?, ?, ?, ?, ?);");
			add.setDouble(1, Double.parseDouble(String.format("%.2f", t.getAmount())));
			add.setTimestamp(2, new Timestamp(date.getTime()));
			add.setString(3, t.getDesc());
			add.setInt(4, t.getAuthor());
			add.setInt(5, 3);
			add.setInt(6, t.getType());
			add.execute();
			
			add.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimburse findByUsername(String name) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection())
		{
			LocalDateTime temp = null; 
			PreparedStatement check = conn.prepareStatement("select * from employee_re.reimbursementview2 where ers_username=?");
			check.setString(1, name);
			ResultSet res = check.executeQuery();
			if(res.next())
			{
				if(res.getTimestamp("reimb_resolved") != null)
					temp = res.getTimestamp("reimb_resolved").toLocalDateTime();
					
				return new Reimburse(res.getInt(1), res.getBigDecimal(2), res.getTimestamp("reimb_submitted").toLocalDateTime(), 
						temp, 
						res.getString("reimb_description"), res.getInt("ers_users_id"),
						res.getInt("reimb_status_id"), res.getInt("reimb_type_id"));
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
