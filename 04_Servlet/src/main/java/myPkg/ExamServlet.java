package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExamServlet
 */
//@WebServlet("/exam") // url mapping 양쪽X
public class ExamServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamServlet() {
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
      //response.getWriter().append("Served at: ").append(request.getContextPath());
	   System.out.print("doGet");
      
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=UTF-8");
      
      PrintWriter out = response.getWriter();
      out.append("<h2>get 방식 요청 들어옴</h2>");
      out.write("가나다<br>");
      out.println("하하하<br>");
      
   }//doGet

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.print("doPost");
	   doGet(request, response);
      
   }
   
}
/*
 * Servlet Life cycle
생성자
init
service
doGet, doPost
destroy
*/

