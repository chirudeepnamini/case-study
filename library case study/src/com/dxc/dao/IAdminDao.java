package com.dxc.dao;

import java.util.List;

import com.dxc.pojo.books;

public interface IAdminDao {

	public void addbook(int bookid,String author,int availability);
	public int bookstatus(int bookid);
	public List<books> getbooks() ;
	public int balance(int id);
	public void delete(int userid);
}
