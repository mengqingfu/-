package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tool.User;

public class LoginDao extends Dao {

	public User login(User user) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select id,pass from members where id=? and pass=?");
		st.setString(1, user.getId());
		st.setString(2, user.getPass());
		ResultSet rs = st.executeQuery();
		User account = null;
		while(rs.next()) {
	    	String id = rs.getString("id");
	    	String pass = rs.getString("pass");

	    	 account = new User(id,pass);
	    }

		st.close();
		con.close();
		return account;
	}
}
