package com.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBcode extends DBconnect implements DBmethods {

	@Override
	public int insertbook(Book bobj) 
	{
		int count=0;
		try
		{
			String q="insert into tblbooks(booktitle, bookauthor, booktypeid, bookdescription,bookprice,bookpublishdate) values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, bobj.getBooktitle());
			pst.setString(2, bobj.getBookauthor());
			pst.setInt(3, bobj.getBooktypeid());
			pst.setString(4, bobj.getBookdescription());
			pst.setInt(5, bobj.getBookprice());
			pst.setString(6, bobj.getBookpublishdate());
			count = pst.executeUpdate();
		}	
		catch(SQLException e) {
			System.out.println(e);
		}
		return count;
	}

	@Override
	public int updatebook(Book bobj) {
		
		int count=0;
		try
		{
			String q="update tblbooks set booktitle=?,bookauthor=?,bookdescription=?,bookprice=?,bookpublishdate=? where bookid=?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, bobj.getBooktitle());
			pst.setString(2, bobj.getBookauthor());
			pst.setString(3, bobj.getBookdescription());
			pst.setInt(4, bobj.getBookprice());
			pst.setString(5, bobj.getBookpublishdate());
			pst.setInt(6, bobj.getBookid());
			count = pst.executeUpdate();
		}	
		catch(SQLException e) {
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return count;
	}

	@Override
	public int deletebook(int bookid) {
		int count=0;
		try
		{
			String q="delete from tblbooks where bookid=?";
			PreparedStatement pst = con.prepareStatement(q);			
			pst.setInt(1,bookid);
			count = pst.executeUpdate();
		}	
		catch(SQLException e) {
			System.out.println(e);
		}
		return count;
	}

	@Override
	public ArrayList<Book> selectallbooks() {
		ArrayList<Book> list = new ArrayList<Book>();
		try
		{
			String q="select * from tblbooks inner join tbltypes on booktypeid=typeid";
			PreparedStatement pst = con.prepareStatement(q);			
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				int bookid = rs.getInt("bookid");
				String booktitle = rs.getString("booktitle");
				String bookauthor = rs.getString("bookauthor");
				int booktypeid = rs.getInt("booktypeid");
				String bookdescription = rs.getString("bookdescription");
				int bookprice = rs.getInt("bookprice");
				String bookpublishdate = rs.getString("bookpublishdate");
				String typename = rs.getString("typename");
				Book obj = new Book(bookid, booktitle, bookauthor, booktypeid, bookdescription, bookprice,bookpublishdate,  typename);
				list.add(obj);
			}
		}	
		catch(SQLException e) {
			System.out.println(e);
		}
		return list;		
	}

	@Override
	public Book selectbookbyid(int bookid) {
		Book bobj = null;
		try
		{
			String q="select * from tblbooks inner join tbltypes on booktypeid=typeid where bookid=?";
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, bookid);
			ResultSet rs = pst.executeQuery();
			rs.next();				
			String booktitle = rs.getString("booktitle");
			String bookauthor = rs.getString("bookauthor");
			int booktypeid = rs.getInt("booktypeid");
			String bookdescription = rs.getString("bookdescription");
			int bookprice = rs.getInt("bookprice");
			String bookpublishdate = rs.getString("bookpublishdate");
			String typename = rs.getString("typename");
			bobj = new Book(bookid, booktitle, bookauthor, booktypeid, bookdescription, bookprice,bookpublishdate,  typename);				
		}	
		catch(SQLException e) {
			System.out.println(e);
		}
		return bobj;	
	}

}
