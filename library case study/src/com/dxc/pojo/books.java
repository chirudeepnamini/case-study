package com.dxc.pojo;

public class books {
	int bookid;
	String author;
	int availability;
	public books(int bookid, String author, int availablity) {
		super();
		this.bookid = bookid;
		this.author = author;
		this.availability = availablity;
	}
	public void display()
	{
		System.out.println("bookid: "+bookid);
		System.out.println("author: "+author);
		System.out.println("availabilty: "+availability);
		System.out.println("-------");
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvailablity() {
		return availability;
	}
	public void setAvailablity(int availablity) {
		this.availability = availablity;
	}
}
