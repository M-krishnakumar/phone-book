package com.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.backend.Book;
import com.backend.DBcode;

/**
 * Servlet implementation class DisplayListST
 */
public class DisplayListST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayListST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h1>Book Information</h1>");
		pw.print("<hr>");
		pw.print("<a href='newbookentryform.html'>Add New Book</a>");
		pw.print("<hr>");
		pw.print("<h2>List of Books</h2>");
		DBcode dbobj = new DBcode();
		ArrayList<Book> books = dbobj.selectallbooks();
		
		pw.print("<table border='6' rules='all'>");
		pw.print("<tr> <th> ID</th> <th> TITLE</th> <th>TYPE</th></tr>");
		for(Book b:books)
		{
			pw.print("<tr>");
			pw.print("<td>"+b.getBookid()+"</td>");
			pw.print("<td>"+b.getBooktitle()+"</td>");
			pw.print("<td>"+b.getTypename()+"</td>");
			pw.print("<td> <a href='EditST?id="+b.getBookid()+"'>Edit</a> </td>");
			pw.print("<td> <a href='DeleteST?id="+b.getBookid()+"'>Remove</a> </td>");
			pw.print("<td> <a href='DisplayDetailsST?id="+b.getBookid()+"'>View More</a> </td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.close();}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
