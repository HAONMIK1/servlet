package myPkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InsertBean eb = new InsertBean();
		eb.setId(request.getParameter("id")); 
		eb.setPassword(request.getParameter("password")); 
		eb.setName(request.getParameter("name"));
		eb.setYear(request.getParameter("year"));
		eb.setMonth(request.getParameter("month"));
		eb.setDay(request.getParameter("day"));
		String[] arr = request.getParameterValues("hobby");
		eb.setHobby(arr);
		eb.setC(Integer.parseInt(request.getParameter("c")));
		eb.setJava(Integer.parseInt(request.getParameter("java")));
		eb.setJsp(Integer.parseInt(request.getParameter("jsp")));

		request.setAttribute("eb", eb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ex03_result.jsp");
		dispatcher.forward(request, response);

	}

}