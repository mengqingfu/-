package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MutterDeleteDao extends Dao{

	public boolean Delete(String id) throws Exception {
		boolean list;
		Connection con = getConnection();
		
		PreparedStatement in = con.prepareStatement("delete from mutter where id = ?");
		in.setString(1, id);
		
		int line = in.executeUpdate();
		in.close();
		con.close();
		if (line > 0) {
			list = true;
		}else {
			list = false;
		}
		
		return list;
	}

}
