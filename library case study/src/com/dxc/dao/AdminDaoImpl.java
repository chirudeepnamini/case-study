package com.dxc.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojo.books;

public class AdminDaoImpl {
	private static Connection con;
	public int openconn() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
		//	System.out.println("driver loaded...");
			
		con=DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgres",
	            "postgres", "611998");
		return 1;
		//	System.out.println("connected to database....");
		}
		catch(Exception e)
		{
			System.out.println("unable to connect to db");
			return 0;
		}
	}
	
	
	public void addbook(int bookid,String author,int availability)
	{
		try {
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO books(bookid,author,availability) VALUES (?,?,?)");
			pstmt.setInt(1, bookid);
			pstmt.setString(2,author);
			pstmt.setInt(3, availability);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("unable to add book due to some issue");
		}
	}
	public List<books> getbooks() {
		
		List<books> list=new ArrayList<>();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from books");
			
			ResultSet rset=pstmt.executeQuery();
			while(rset.next())
			{
				list.add(new books(rset.getInt(1), rset.getString(2), rset.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int balance(int userid)
	{
		int bal=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("select balance from users where userid=?");
			pstmt.setInt(1, userid);
			ResultSet rset=pstmt.executeQuery();
			while(rset.next())
			{
				bal=rset.getInt(1);
			}
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		//return null;
		return bal;
	}
	public void delete(int userid)
	{
		
		try {
			PreparedStatement pstmt=con.prepareStatement("DELETE FROM users where userid=?");
			pstmt.setInt(1, userid);
			pstmt.executeQuery();
		
			
			
		} 
		catch (SQLException e)
		{
			System.out.println("user deleted");
		}
		//return null;
		//return bal;
	}
	public void deletebook(int bookid)
	{
		
		try {
			PreparedStatement pstmt=con.prepareStatement("DELETE FROM books where bookid=?");
			pstmt.setInt(1, bookid);
			pstmt.executeQuery();
		
			
			
		} 
		catch (SQLException e)
		{
			System.out.println("book deleted");
		}
		//return null;
		//return bal;
	}
}

