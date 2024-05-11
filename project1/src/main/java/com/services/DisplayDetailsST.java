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
 * Servlet implementation class DisplayDetailsST
 */
public class DisplayDetailsST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDetailsST() {
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
		pw.print("<h1>Book Information</h1>");
		pw.print("<hr>");
		pw.print("<h2>Details of "+b.getBooktitle()+"</h2>");
		pw.print("<p>ID : "+b.getBooktitle()+"</p>");
		pw.print("<p>TITLE : "+b.getBooktitle()+"</p>");
		pw.print("<p>AUTHOR	 : "+b.getBookauthor()+"</p>");
		pw.print("<p>TYPE : "+b.getTypename()+"</p>");
		pw.print("<p>DESCRIPTION : "+b.getBookdescription()+"</p>");
		pw.print("<p>PRICE : "+b.getBookprice()+"</p>");
		pw.print("<p>DATE OF PUBLISHING : "+b.getBookpublishdate()+"</p>");
		pw.print("<a href='EditST?id="+b.getBookid()+"'>Edit</a>");
		pw.print("<a href='DeleteST?id="+b.getBookid()+"'>Remove</a>");
		pw.print("<a href='DisplayListST'>Home</a>");
		
		
		pw.close();}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
