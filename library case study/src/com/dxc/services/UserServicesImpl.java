package com.dxc.services;

import java.util.List;

import com.dxc.pojo.books;
import com.dxc.dao.UserDaoImpl;

public class UserServicesImpl {
	UserDaoImpl dao=new UserDaoImpl();
	

	public void bookissue(int bookid,int userid)
	{	int status;
		status=dao.bookstatus(bookid);
		if(status==1)
		dao.bookissue(bookid, userid);
		else if(status==0)
		System.out.println("book not available");
	}
	
	public List<books> getbooksbyauthor(String authorname)
	{
		return dao.getbooksbyauthor(authorname);
	}
	public int balance(int id)
	{
		return dao.balance(id);
	}
	
}
