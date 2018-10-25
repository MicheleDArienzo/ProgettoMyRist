package com.MyRist.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyRist.Model.ComuniImpl;
import com.MyRist.Model.ProvinceImpl;

/**
 * Servlet implementation class prendiComuni
 */
public class prendiComuni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prendiComuni() {
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
		ComuniImpl comimp = new ComuniImpl();
		
		HttpSession hs = request.getSession();
		ArrayList<String> list = comimp.getComuni((String)hs.getAttribute("regioni"), request.getParameter("province"));
		hs.setAttribute("comuni", list);
		response.sendRedirect("index.jsp");
	}

}
