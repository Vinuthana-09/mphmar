package com.mph.model;
//pojo -plain old java object class-->must have only private instance variables and punlic methods
public class Employe
{
	private int eid;
	private String ename;
	private Salary salary;
	private String dept;
	public Employe()
	{
		System.out.println("constructor called");
	}
	
	public Employe(int eid,String ename)
	{
        this.eid=eid;
        this.ename=ename;
	}
	
	public void setEid(int eid)
	{
		this.eid=eid;
	}
	
	public int getEid()
	{
		return eid;		
	}
	public void setEname(String ename)
	{
		this.ename=ename;
	}
	
	public String getEname()
	{
		return ename;		
	}
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", dept=" + dept + "]";
	}

	
	

}