package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemServlet
 */
  //@WebServlet("/memReg")
public class MemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemServlet() {
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
	      PrintWriter out = response.getWriter();
	      
	      String name= request.getParameter("name");      
	      String addr= request.getParameter("addr");      
	      String tel= request.getParameter("tel");
	      String[] hobby= request.getParameterValues("hobby");
	      String hobbys="";
	      for(String i: hobby) {
	    	  hobbys+=i+"";
	      }
	      out.append("이름:"+name+"<br>");
	      out.println("주소:"+addr+"<br>");
	      out.write("전화번호:"+tel+"<br>");
	      out.write("취미:"+hobbys+"<br>");
	      
	      doGet(request, response);
	}

}
