package web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getServletPath();
		if("/find.do".equals(url)){
			findEmp(req,res);
		}else if("/save.do".equals(url)){
			save(req,res);
		}else if("/modify.do".equals(url)){
			modify(req,res);
		}else if("/delete.do".equals(url)){
			deleteEmp(req,res);
		}
	}
	protected void findEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		req.setAttribute("emps",list);
		req.getRequestDispatcher("emp.jsp").forward(req, res);
	}
	protected void modify(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//处理表单传过来的生日
		EmpDao dao = new EmpDao();
		Emp e = new Emp();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String bir = req.getParameter("birthday");
		java.util.Date d = null;
		try {
			d = sdf.parse(bir);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Long ms = d.getTime();
		e.setId(Integer.parseInt(req.getParameter("eid")));
		e.setName(req.getParameter("name"));
		e.setGender(req.getParameter("gender"));
		e.setBirthday(new Date(ms));
		e.setJob(req.getParameter("job"));
		e.setSal(Double.parseDouble(req.getParameter("sal")));
		dao.modify(e);
		res.sendRedirect("find.do");
	}
	protected void deleteEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDao dao = new EmpDao();
		int id = Integer.parseInt(req.getParameter("id"));
		dao.deleteEmp(id);
		res.sendRedirect("find.do");
	}
	protected void save(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDao dao = new EmpDao();
		Emp e = new Emp();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String bir = req.getParameter("birthday");
		java.util.Date d = null;
		try {
			d = sdf.parse(bir);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Long ms = d.getTime();
		e.setName(req.getParameter("name"));
		e.setGender(req.getParameter("gender"));
		e.setBirthday(new Date(ms));
		e.setJob(req.getParameter("job"));
		e.setSal(Double.parseDouble(req.getParameter("sal")));
		dao.save(e);
		res.sendRedirect("find.do");
	}

}
