package com.MyRist.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyRist.Model.Ristoranti;
import com.MyRist.Model.RistorantiImpl;

/**
 * Servlet implementation class stampaRistoranti
 */
public class stampaRistoranti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stampaRistoranti() {
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
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession();
		RistorantiImpl ristimp = new RistorantiImpl();
		ArrayList<Ristoranti> list = new ArrayList<Ristoranti>();
		if((hs.getAttribute("regione") != null || hs.getAttribute("regione") != "blank") && (hs.getAttribute("provincia") != null || hs.getAttribute("provincia") != "blank") && (request.getParameter("comuni") != null || request.getParameter("comuni") != "blank") && (request.getParameter("nome") != null || request.getParameter("nome") != "") && (request.getParameter("tipicucina") != null || request.getParameter("tipicucina")!="blank"))
		{
			list = ristimp.queryRegioneProvinciaComuneNome((String)hs.getAttribute("regione"), (String)hs.getAttribute("provincia"), request.getParameter("comuni"), request.getParameter("nome"));
		} 
		else if((hs.getAttribute("regione") != null || hs.getAttribute("regione") != "blank") && (hs.getAttribute("provincia") != null || hs.getAttribute("provincia") != "blank") && (request.getParameter("comuni") != null || request.getParameter("comuni") != "blank"))
		{
			list = ristimp.queryRegioneProvinciaComune((String)hs.getAttribute("regione"), (String)hs.getAttribute("provincia"), request.getParameter("comuni"));
		}
		else if((hs.getAttribute("regione") != null || hs.getAttribute("regione") != "blank") && (hs.getAttribute("provincia") != null || hs.getAttribute("provincia") != "blank"))
		{
			list = ristimp.queryRegioneProvincia((String)hs.getAttribute("regione"), (String)hs.getAttribute("provincia"));
		}
		else if((hs.getAttribute("regione") != null || hs.getAttribute("regione") != "blank"))
		{
			list = ristimp.queryRegione((String)hs.getAttribute("regione"));
		}
		else if((request.getParameter("nome") != null || request.getParameter("nome") != ""))
		{
			list = ristimp.queryNome(request.getParameter("nome"));
		}
		else if(request.getParameter("tipicucina") != null || request.getParameter("tipicucina")!="blank")
		{
			list = ristimp.queryTipo(request.getParameter("tipicucina"));
		}
		
		hs.setAttribute("ricercaCompleta", list);
		hs.setAttribute("ricercaFatta", "fatto");
		
		response.sendRedirect("index.jsp");
	}

}
