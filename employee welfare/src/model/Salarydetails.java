package model;

import java.time.Month;

public class Salarydetails {
	private static String empid;
	private String name;
	private Month month;
	private int year;
	private int totalearning;
	private int deductions;
	private int netamount;
	public Salarydetails(String empid,String name, Month month, int year, int totalearning, int deductions, int netamount) {
		super();
		this.empid = empid;
		this.name=name;
		this.month = month;
		this.year = year;
		this.totalearning = totalearning;
		this.deductions = deductions;
		this.netamount = netamount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public Month getMonth() {
		return month;
	}
	public void setMonth(Month month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTotalearning() {
		return totalearning;
	}
	public void setTotalearning(int totalearning) {
		this.totalearning = totalearning;
	}
	public int getDeductions() {
		return deductions;
	}
	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}
	public int getNetamount() {
		return netamount;
	}
	public void setNetamount(int netamount) {
		this.netamount = netamount;
	}
	public void display() {
		System.out.println(getEmpid()+getTotalearning());
		
	}
	

}
