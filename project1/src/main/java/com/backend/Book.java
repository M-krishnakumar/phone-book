package com.backend;

public class Book {
	private int bookid;
	private String booktitle;
	private String bookauthor;
	private int booktypeid;
	private String bookdescription;
	private int bookprice;
	private String bookpublishdate;
	private String typename;
	public Book(String booktitle, String bookauthor, int booktypeid, String bookdescription, int bookprice,String bookpublishdate) {
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.booktypeid = booktypeid;
		this.bookdescription = bookdescription;
		this.bookprice = bookprice;
		this.bookpublishdate = bookpublishdate;
	}
	public Book(int bookid, String booktitle, String bookauthor, int booktypeid, String bookdescription, int bookprice,
			String bookpublishdate, String typename) {
		this.bookid = bookid;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.booktypeid = booktypeid;
		this.bookdescription = bookdescription;
		this.bookprice = bookprice;
		this.bookpublishdate = bookpublishdate;
		this.typename = typename;
	}
	
	public Book(int bookid, String booktitle, String bookauthor, int booktypeid, String bookdescription, int bookprice,
			String bookpublishdate) {
		super();
		this.bookid = bookid;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.booktypeid = booktypeid;
		this.bookdescription = bookdescription;
		this.bookprice = bookprice;
		this.bookpublishdate = bookpublishdate;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public int getBooktypeid() {
		return booktypeid;
	}
	public void setBooktypeid(int booktypeid) {
		this.booktypeid = booktypeid;
	}
	public String getBookdescription() {
		return bookdescription;
	}
	public void setBookdescription(String bookdescription) {
		this.bookdescription = bookdescription;
	}
	public int getBookprice() {
		return bookprice;
	}
	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}
	public String getBookpublishdate() {
		return bookpublishdate;
	}
	public void setBookpublishdate(String bookpublishdate) {
		this.bookpublishdate = bookpublishdate;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}
