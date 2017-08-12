package util;

import java.sql.SQLException;

import org.junit.Test;

public class testUtil {
	@Test
	public void test(){
		try {
			System.out.println(DBUtil.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
