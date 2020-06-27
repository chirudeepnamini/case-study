package com.dxc.services;

import java.util.List;

import com.dxc.pojo.books;

public interface IUserServices {
	public void bookissue(int bookid,int userid);
	public int bookstatus(int bookid);
	public List<books> getbooksbyauthor(String authorname);
	public int balance(int id);
	
}
