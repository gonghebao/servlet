package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import util.DBUtil;

public class EmpDao implements Serializable {
	public List<Emp> findAll() {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from emp";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("id"));
				e.setBirthday(rs.getDate("birthday"));
				e.setGender(rs.getString("gender"));
				e.setJob(rs.getString("job"));
				e.setName(rs.getString("name"));
				e.setSal(rs.getDouble("sal"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}

	public void save(Emp e) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into emp values(null,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getGender());
			ps.setDate(3, e.getBirthday());
			ps.setString(4, e.getJob());
			ps.setDouble(5, e.getSal());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}
	public void modify(Emp e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update emp set name=?,gender=?,birthday=?,job=?,sal=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,e.getName());
			ps.setString(2,e.getGender());
			ps.setDate(3, e.getBirthday());
			ps.setString(4,e.getJob());
			ps.setDouble(5,e.getSal());
			ps.setInt(6, e.getId());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public void deleteEmp(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from emp where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
