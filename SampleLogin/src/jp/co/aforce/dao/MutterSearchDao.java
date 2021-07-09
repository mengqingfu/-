package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tool.Mutter;

public class MutterSearchDao extends Dao{

	public List<Mutter> Search(String data) throws Exception {
		List<Mutter> mutterList = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select * from mutter where data like ?");
		st.setString(1,"%"+data+"%");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
	    	String id = rs.getString("id");
	    	String data1 = rs.getString("data");
	    	String hour = rs.getString("hour");
            Mutter mutter = new Mutter(id,data1,hour);
            mutterList.add(mutter);
	    	 
	    }

		st.close();
		con.close();
		return mutterList;
	}


}
