package com.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.backend.Book;
import com.backend.DBcode;
/**
 * Servlet implementation class EditST
 */
public class EditST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int bookid = Integer.parseInt(request.getParameter("id"));
		DBcode dbobj = new DBcode();
		Book b = dbobj.selectbookbyid(bookid);
		PrintWriter pw = response.getWriter();
		pw.print("<h2>Edit Form</h2>");
		pw.print("<form method='post' action='EditST'>");
		
		pw.print("<label>Title</label>");
		pw.print("<input readonly type='text' name='booktitle' required minlength='3' maxlength='600' value='"+b.getBooktitle()+"'> <br>");
		
		
		pw.print("<label>Author</label>");
		pw.print("<input type='text' name='bookauthor' required minlength='3' maxlength='100' value='"+b.getBookauthor()+"'> <br>");
		
		pw.print("<label>Description</label>");
		pw.print("<textarea rows='5' required name='bookdescription'>"+b.getBookdescription()+"</textarea>  <br>");
		
		pw.print("<label>Price</label>");
		pw.print("<input type='number' name='bookprice' required min='1' max='100000' value='"+b.getBookprice()+"'>	 <br>");
		
		pw.print("<label>Date of Publishing</label>");
		pw.print("<input type='date' required name='bookpublishdate' value='"+b.getBookpublishdate()+"'>  <br>");
		
		pw.print("<label>Type of Book</label>");
		pw.print("<input readonly type='text' name='typename' value='"+b.getTypename()+"'>  <br>");
		
		pw.print("<input type='hidden' name='booktypeid' value='"+b.getBooktypeid()+"'>");
		pw.print("<input type='hidden' name='bookid' value='"+b.getBookid()+"'>");
		pw.print("<input type='submit' value='Save'> <br>");
		pw.print("<a href='DisplayListST'>Home</a>");		
		pw.print("</form>");
		pw.close();}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//receive input from user
				String booktitle = request.getParameter("booktitle");
				String bookauthor = request.getParameter("bookauthor");
				String bookdescription = request.getParameter("bookdescription");
				String bookpublishdate = request.getParameter("bookpublishdate");

				int bookprice = Integer.parseInt(request.getParameter("bookprice"));
				int booktypeid = Integer.parseInt(request.getParameter("booktypeid"));
				int bookid = Integer.parseInt(request.getParameter("bookid"));
						
				//create object for Book class with these inputs
				Book b = new Book(bookid,booktitle, bookauthor, booktypeid, bookdescription, bookprice,bookpublishdate);
				
				//dbcode class - object create
				DBcode dbobj = new DBcode();
				//call insert()
				int count = dbobj.updatebook(b);
				if(count==1)
				{
					response.sendRedirect("DisplayListST");
				}
				else
				{
					PrintWriter pw = response.getWriter();
					pw.print("<h1>Book data not saved</h1>");
					pw.close();
				}
						
			}


}
