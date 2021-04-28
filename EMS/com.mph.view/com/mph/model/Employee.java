package com.mph.model;

import java.io.Serializable;
import java.util.Comparator;

//pojo -plain old java object class-->must have only private instance variables and punlic methods
public class Employee implements Serializable ,Comparable<Employee>
{
	private int eid;
	private String ename;
	private Salary salary;
	private String dept;
	
	public Employee()
	{
		System.out.println("constructor called");
	}
	
	public Employee(int eid,String ename)
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

	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", dept=" + dept + "]";
	}
//namecomparator
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() 
	{
		public int compare(Employee e1, Employee e2)
		{
			return (e1.getEname().compareToIgnoreCase(e2.getEname()));
		}
		
	};

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
}