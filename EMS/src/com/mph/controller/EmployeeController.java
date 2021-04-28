package com.mph.controller;

import java.io.FileInputStream;
import com.mph.dao.EmployeeDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.mph.model.Employee;
import com.mph.model.Salary;

import com.mph.model.Manager;
public class EmployeeController implements EmployeeInterface
{
	Employee emp;
	Salary sal;
	Manager m;
	
	List<Employee> li=new ArrayList<Employee>();
	EmployeeDao empdao = new EmployeeDao();
	interface Loop
	
	{
		public void accept(List<Employee> elis);
	}
	public List<Employee> addEmployee( )
	{
		emp = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		emp.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		emp.setEname(enam);
		
		sal= new Salary();
		System.out.println("Enter basic Salary");
		int basic = sc.nextInt();
		sal.setBasic(basic);
		System.out.println("Enter DA");
		int da = sc.nextInt();
		sal.setDa(da);
		System.out.println("Enter HRA");
		int hra = sc.nextInt();
		sal.setHra(hra);
		System.out.println("Enter PF");
		int pf= sc.nextInt();
		sal.setPf(pf);

		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(),pf);
		
		emp.setSalary(sal);
		
		m=new Manager();
		System.out.println("enter dept");
		String dept=sc.next();
		m.setDept(dept);
		emp.setDept(dept);
	   //System.out.println(emp.getEid() + " " + emp.getEname());	
		System.out.println("Employee "  + eno + "Succesfully added");
		
		li.add(emp);
		return li;
		
		
	}
	
	public void viewEmployee(List elist)
	{
		/*Iterator i= elist.iterator();

		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		*/
		Consumer c=(elis)->
		{
		System.out.println(elis);
		};
		li.forEach(c);
		
	}
	
	@SuppressWarnings("unchecked")
	public void sortEmployee()
	{
		Collections.sort(li,Employee.nameComparator);
		System.out.println("list"+ li);
		
	}

	public void nameStart()
	{
		List<Employee> name=li.stream().filter(emp1->emp1.getEname().startsWith("a")||emp1.getEname().startsWith("A")).collect(Collectors.toList());
		System.out.println("names starts with A:"+ name);
	}
	
	@Override
	public void Serial() {
		{ 
			FileOutputStream fos =null ;
			ObjectOutputStream oos =null;
			try
			{
				fos= new FileOutputStream("serialdata.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(emp);
				System.out.println(" Serialization done...");
				}
			catch (FileNotFoundException e)
			{	
				e.printStackTrace();
			} 
			catch (IOException e) 
			{	
				e.printStackTrace();
			}finally 
			{
				try
				{
					fos.close();
					oos.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}


	public void Deserial()
		// TODO Auto-generated method stub
		{
			Employee eg=emp;
			try (FileInputStream fis = new FileInputStream("serialdata.txt");
					ObjectInputStream ois = new ObjectInputStream(fis))
					{
							eg=(Employee)ois.readObject();
							fis.close();
							ois.close();
					}
					catch (ClassNotFoundException | IOException e)
					{
							
							e.printStackTrace();
						}
						System.out.println(eg.getDept());
						System.out.println(eg.getEid());
						System.out.println(eg.getEname());
						System.out.println(eg.getSalary());
					
					
				}
	public void insertUsingProc()
	{
		Employee e = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		e.setEname(enam);
		
		empdao.insertUsingProcedure(e);
	}

	public void rsmd()
	{
		empdao.rsmd();
	}
	@Override
	public void type_forward_only_rs() {
		empdao.type_forward_only_rs();
		
	}

	@Override
	public void type_scroll_insensitive_rs() {
		empdao.type_scroll_insensitive_rs();
		
	}


	@Override
	public void type_scroll_sensitive_rs_insert() {
		empdao.type_scroll_sensitive_rs_insert();
	//	empdao.type_scroll_sensitive_rs_update();
		

	}
	

	
	@Override
	public void type_scroll_sensitive_rs_update() {
		empdao.type_scroll_sensitive_rs_update();
	//	empdao.type_scroll_sensitive_rs_update();
		

	}
	@Override
	public void batchUpdate() {
		empdao.batchUpdate();
		
	}
	
	}

	


		