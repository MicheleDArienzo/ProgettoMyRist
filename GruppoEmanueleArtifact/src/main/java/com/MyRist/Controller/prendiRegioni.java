package com.MyRist.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MyRist.Model.RegioniImpl;

/**
 * Servlet implementation class prendiRegioni
 */
public class prendiRegioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegioniImpl reg = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prendiRegioni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("regioni", reg.getRegioni());
	}

}
