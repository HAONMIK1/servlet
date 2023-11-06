package sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActorServlet
 */
//@WebServlet("/actor.do")
public class ActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String company;
	String actor;
	String title;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActorServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	//ServletConfig config = new ServletConfig()
	// ServletConfig는 서블릿 당 하나 
	// ServletContext는 웹 애플리케이션당 하나 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");

		ServletContext sc = config.getServletContext();
		company = sc.getInitParameter("company");
		actor = sc.getInitParameter("actor");

		title = config.getInitParameter("title");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request,response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("회사명:"+company+"<br>");
		out.write("배우명:"+actor+"<br>");
		out.write("작품명:"+title+"<br>");

	}
}