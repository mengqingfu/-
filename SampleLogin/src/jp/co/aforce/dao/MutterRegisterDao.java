package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import tool.Mutter;

public class MutterRegisterDao extends Dao{

	public boolean Register(Mutter mutter) throws Exception {
		boolean list;
		Connection con = getConnection();
		
		PreparedStatement in = con.prepareStatement("INSERT INTO MUTTER (id, data,hour) VALUES (?,?,?)");
		in.setString(1, mutter.getId());
		in.setString(2, mutter.getData());
		in.setString(3, mutter.getHour());
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
