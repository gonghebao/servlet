package entity;

import java.io.Serializable;
import java.sql.Date;

public class Emp implements Serializable {
	private int id;
	private String name;
	private String gender;
	private Date birthday;
	private String job;
	private Double sal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", job=" + job
				+ ", sal=" + sal + "]";
	}
	
}
