/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heyrul.model.User;
import com.heyrul.utils.DBUtils;

public class UserDao {
	
	public void insert(User user) throws SQLException {
		DBUtils.getConnectionPostgreSQL().setAutoCommit(false);
		
		String sql = "INSERT INTO USER(first_name, last_name, username, password, email, reg_date) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = DBUtils.getConnectionPostgreSQL().prepareStatement(sql);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getEmail());
		ps.setTimestamp(6, user.getRegDate());
		ps.executeUpdate();
		
		DBUtils.getConnectionPostgreSQL().commit();
	}
	
	public void update(User user) throws SQLException {
		DBUtils.getConnectionMSSQL().setAutoCommit(false);
		
		String sql = "UPDATE USER SET id=?, first_name=?, last_name=?, username=?, password=?, email=?, reg_date=? WHERE id=?";
		PreparedStatement ps = DBUtils.getConnectionMSSQL().prepareStatement(sql);
		ps.setLong(1, user.getId());
		ps.setString(2, user.getFirstName());
		ps.setString(3, user.getLastName());
		ps.setString(4, user.getUsername());
		ps.setString(5, user.getPassword());
		ps.setString(6, user.getEmail());
		ps.setTimestamp(7, user.getRegDate());
		ps.setLong(8, user.getId());
		ps.executeUpdate();
		
		DBUtils.getConnectionMSSQL().commit();
	}
	
	public void delete(Long id) throws SQLException {
		DBUtils.getConnectionMySQL().setAutoCommit(false);
		
		String sql = "DELETE FROM USER WHERE id=?";
		PreparedStatement ps = DBUtils.getConnectionMySQL().prepareStatement(sql);
		ps.executeUpdate();
		
		DBUtils.getConnectionMySQL().commit();
	}
	
	public List<User> getAll() throws SQLException {
		List<User> data = new ArrayList<User>();
		
		String sql = "SELECT * FROM USER";
		PreparedStatement ps = DBUtils.getConnectionOracle().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setRegDate(rs.getTimestamp("reg_date"));
			data.add(user);
		}
		return data;
	}
	
	public User findById(Long id) throws SQLException {
		String sql = "SELECT * FROM USER WHERE id=?";
		PreparedStatement ps = DBUtils.getConnectionOracle().prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setRegDate(rs.getTimestamp("reg_date"));
			return user;
		}
		return null;
	}

}
