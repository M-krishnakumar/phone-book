package com.backend;

import java.util.ArrayList;

public interface DBmethods {
	public int insertbook(Book bobj);
	public int updatebook(Book bobj);
	public int deletebook(int bookid);
	public ArrayList<Book> selectallbooks();
	public Book selectbookbyid(int bookid);	
}
