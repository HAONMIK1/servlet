package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class doServlet
 */
/*
 * @WebServlet(urlPatterns =
 * {"/insert.do","/update.do","/delete.do","/update.do"})
 */
//@WebServlet("*.do") /* 별앞에는 / 절대 쓰지 않는다. */
public class doServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doAction(request,response);
   }


   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doAction(request,response);
   }
   private void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
     String uri = request.getRequestURI();
     StringBuffer url = request.getRequestURL();
     String conPath = request.getContextPath();
     int len = conPath.length();
     String command = uri.substring(len);
     
     System.out.println("uri"+uri);
     System.out.println("url"+url);
     System.out.println("compath"+conPath);
     System.out.println("len"+len);
     System.out.println("command"+command);
   }

}