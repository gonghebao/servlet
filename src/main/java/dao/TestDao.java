package dao;

import org.junit.Test;

public class TestDao {
	@Test
	public void test(){
		EmpDao dao = new EmpDao();
		System.out.println(dao.findAll());
	}
}
