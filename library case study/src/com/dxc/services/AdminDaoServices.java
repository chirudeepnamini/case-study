package com.dxc.services;
import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IAdminDao;
import com.dxc.pojo.books;
import com.dxc.pojo.users;

public class AdminDaoServices implements IAdminServices{
	AdminDaoImpl dao=new AdminDaoImpl();
	
	public void addbook(int bookid,String author,int availability)
	{
		dao.addbook(bookid,author,availability);
	}	
	
	public List<books> getbooks()
	{
		return dao.getbooks();
	}
	public int balance(int userid)
	{
		return dao.balance(userid);
	}
	public void delete(int userid)
	{
		dao.delete(userid);
	}
	
	

}
