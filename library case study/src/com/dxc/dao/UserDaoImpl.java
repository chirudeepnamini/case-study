package com.dxc.dao;
import java.sql.*;
import java.util.*;
import com.dxc.pojo.*;

public class UserDaoImpl {
private static Connection conn;
	
	static {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
		//	System.out.println("driver loaded...");
			
		conn=DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgres",
	            "postgres", "611998");
		//	System.out.println("connected to database....");
		}
		catch(Exception e)
		{	System.out.println("unable to connect");
			e.printStackTrace();
		}
	}

	public int login(int userid,String password)
	{
		try {
			PreparedStatement pstmt=conn.prepareStatement("select  password from users where userid=?");
			pstmt.setInt(1, userid);
			ResultSet rset=pstmt.executeQuery();
			while(rset.next())
			{
			String pass=rset.getString(1);
			//System.out.println(pass);
			if(pass.equals(password)&& userid==0)
			{
				return 1;
			}
			else if(pass.equals(password)&&userid>0)
			{
				return -1;
			}
			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
public void bookissue(int bookid,int userid,int days)
{
	int avail=0;int bal=0;
	try {
		PreparedStatement pstmt=conn.prepareStatement("select availability from books where bookid=?");
		pstmt.setInt(1, bookid);
		ResultSet rset=pstmt.executeQuery();
		while(rset.next())
		{
			avail=rset.getInt(1);
		}
		
		
	} 
	catch (SQLException e)
	{	System.out.println("faillure while checking book avaialability");
		e.printStackTrace();
	}
	
	try {
		PreparedStatement pstmt=conn.prepareStatement("select balance from users where userid=?");
		pstmt.setInt(1, userid);
		ResultSet rset=pstmt.executeQuery();
		while(rset.next())
		{
			bal=rset.getInt(1);
		}
		
		
	} 
	catch (SQLException e)
	{	System.out.println("failure while checking balance");
		e.printStackTrace();
	}
	if(avail==1 && ((bal-days*5)>=0))
	{
		try {
			PreparedStatement pstmt=conn.prepareStatement("update books set availability=? where bookid=?");
			pstmt.setInt(1, 0);
			pstmt.setInt(2, bookid);
			pstmt.execute();
			
		} catch (SQLException e) {
			System.out.println("failure while updating book availabilty");
			e.printStackTrace();
		}
		try {
			PreparedStatement pstmt=conn.prepareStatement("INSERT INTO allotment(bookid,userid) VALUES (?,?)");
			pstmt.setInt(1, bookid);
			pstmt.setInt(2, userid);
			pstmt.execute();
			bal=bal-days*5;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	else if(avail==0)
	{
		System.out.println("book not available");
	}
	else if((bal-days*5)<0)
	{
		System.out.println("insufficient balance");
	}
}

	
public int bookstatus(int bookid)
{	 int status=-1;
	try {
	PreparedStatement pstmt=conn.prepareStatement("select availaility from books where bookid=?");
	pstmt.setInt(1, bookid);
	ResultSet rset=pstmt.executeQuery();
	status=rset.getInt(1);
	
	
} 
catch (SQLException e)
{
	e.printStackTrace();
}
	
	return status;
	}

	

public List<books> getbooksbyauthor(String authorname) {
		
		List<books> list=new ArrayList<>();
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from books where author=?");
			pstmt.setString(1, authorname);
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
	public int balance(int id)
	{
		int bal=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select balance from users where userid=?");
			pstmt.setInt(1, id);
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

}
