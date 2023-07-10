package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccesPage;


@WebServlet("/")
public class MyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		
		switch (path)
		{
		case "/logCustomer":
			validateCustomer(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
		case "/reg":
			getRegistrationPage(request,response);
			break;
		case "/log":
			getLoginPage(request,response);
			break;
		   default:
		   getStartUpPage(request,response);
		   break;
		}
		
	}
 

	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
	 //read the email and password from lpgin jsp page
		 String e=request.getParameter("tbEmailLog");
		 String p=request.getParameter("tbPassLog");
		 //call the metod present in dao
		boolean res= DataAccess.validateCustomer(e, p);
		
		//condition and redirect to destimation page(success page)
		if(res)
		{
			try
			{
				RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
				
				//store the 	sucess age data inside rd
				SuccesPage sp=new SuccesPage();
				request.setAttribute("succesDetails", sp);
				
				
				rd.forward(request, response);
			} 
			catch (ServletException e1) 
			{
				e1.printStackTrace();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		else
		{
			// short form of code present in if block and same code is present in get login page method
			getLoginPage(request, response);
			
		}
	
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//read the data from jsp page
		String n=request.getParameter("tbName");
		String e=request.getParameter("tbEmail");
		String m=request.getParameter("tbMobile");
		String p=request.getParameter("tbPass");
		String s=request.getParameter("ddlStates");
		
		//store the data in customer model or object
		Customer c=new  Customer(n, e, m, p, s);
		
		
		//call insert customer method present in dao by passing above object
		DataAccess.insertCustomer(c);
		
		//redirect customer to login page
		
		try
		{
			RequestDispatcher rd= request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
		
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response)
	{
	
	
	  try 
	   {
		    RequestDispatcher rd=request.getRequestDispatcher("customer_management.jsp");
		    rd.forward(request, response);
	   }
	    catch (ServletException e)
	    {
		   e.printStackTrace();
	    }
	     catch (IOException e)
     	 { 
	    	e.printStackTrace();
	      }  
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}









