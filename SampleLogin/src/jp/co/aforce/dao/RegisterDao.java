package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tool.User;

public class RegisterDao extends Dao {

	public boolean register(User user) throws Exception {
		boolean list = false;
		User account = null;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select id,pass from members where id=?");
		st.setString(1, user.getId());
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			String id = rs.getString("id");
			String pass = rs.getString("pass");

			account = new User(id, pass);
		}
		st.close();
		con.close();

		if (account != null) {
			list = false;
		} else {
			con = getConnection();
			PreparedStatement in = con.prepareStatement("insert into members values(?,? )");
			in.setString(1, user.getId());
			in.setString(2, user.getPass());
			int line = in.executeUpdate();
			in.close();
			con.close();
			if (line > 0) {
				list = true;
			}
		}
		return list;
	}

}
