package myPkg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MFrontController
 */
//@WebServlet("/MFrontController")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext sc = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MFrontController() {
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	sc = config.getServletContext();
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

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		int len = path.length();
		String command = uri.substring(len);
		String viewPage = "";
		boolean flag = (Boolean)sc.getAttribute("flag");
		MemberCommand mCommand =null;
		  if(command.equals("/list.do")) {
			  	mCommand = new MListCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "list.jsp";
		    }
		    else  if(command.equals("/insert.do")) {
		    	if(flag==false) {
		    	 mCommand = new MInsertCommand();
		    	mCommand.execute(request,response);
		    	sc.setAttribute("flag", true);
		    	
		    	viewPage = "list.do";
		    	}else {
		    	viewPage = "list.do";
		    	}
		    }
		    else  if(command.equals("/delete.do")) {
		    	mCommand = new MDeleteCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "list.do";
		    }
		    else  if(command.equals("/update.do")) {
		    	mCommand = new MUpdateCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "list.do";
		  
		    }
		    else  if(command.equals("/updateForm.do")) {
		    
		    	mCommand = new MUpdateFormCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "updateForm.jsp";
		    	
		    	
		    }
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
