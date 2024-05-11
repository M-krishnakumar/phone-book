package com.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.backend.Book;
import com.backend.DBcode;
import java.io.PrintWriter;
/**
 * Servlet implementation class SaveST
 */
public class SaveST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
				
				//create object for Book class with these inputs
				Book b = new Book(booktitle, bookauthor, booktypeid, bookdescription, bookprice,bookpublishdate);
				
				//dbcode class - object create
				DBcode dbobj = new DBcode();
				
				//call insert()
				int count = dbobj.insertbook(b);
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
