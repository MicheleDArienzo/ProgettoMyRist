package com.MyRist.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyRist.Model.ProvinceImpl;

/**
 * Servlet implementation class prendiProvince
 */
public class prendiProvince extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prendiProvince() {
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
		ProvinceImpl provimp = new ProvinceImpl();
		ArrayList<String> list = provimp.getProvince(request.getParameter("regioni"));
		HttpSession hs = request.getSession();
		hs.setAttribute("regione", request.getParameter("regioni"));
		hs.setAttribute("province", list);
		hs.setAttribute("comuni", null);
		hs.setAttribute("ricerca", 1);
		response.sendRedirect("index.jsp");
		
	}

}
