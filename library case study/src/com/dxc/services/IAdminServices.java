package com.dxc.services;
import java.util.List;
import com.dxc.pojo.users;
import com.dxc.pojo.books;

public interface IAdminServices {

	public void addbook(int bookid,String author,int availability);
	//public int bookstatus(int bookid);
	public List<books> getbooks() ;
	public int balance(int id);
	public void delete(int userid);
	}
