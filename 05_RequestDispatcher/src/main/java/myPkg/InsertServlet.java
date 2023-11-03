package myPkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	      response.setContentType("text/html;charset=UTF-8");
	      String[] hobby =request.getParameterValues("hobby");
	      String hbs="";
	      for(String i : hobby) {
	    	  hbs+=i+" ";
	      }
	      String birth1 =request.getParameter("birth1");
	      String birth2 =request.getParameter("birth2");
	      String birth3 =request.getParameter("birth3");
	      String birth = birth1+"년 "+birth2+"월 "+birth3+"일";
	      request.setAttribute("hbs", hbs);
		request.setAttribute("birth", birth);
	  	RequestDispatcher dispatcher = request.getRequestDispatcher("result_김노아.jsp");
		dispatcher.forward(request, response);
	}

}
