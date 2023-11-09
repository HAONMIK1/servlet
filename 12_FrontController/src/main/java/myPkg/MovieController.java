package myPkg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieController
 */
@WebServlet("/MovieController")
public class MovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext  sc =null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		MovieCommand mCommand =null;
		
		  if(command.equals("/list.mv")) {
			  	mCommand = new MListCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "list.jsp";
		    }
		    else  if(command.equals("/insert.mv")) {
		    	if(flag==false) {
		    	 mCommand = new MInsertCommand();
		    	mCommand.execute(request,response);
		    	sc.setAttribute("flag", true);
		    	viewPage = "list.mv";
		    	}else {
		    	viewPage = "list.mv";
		    	}
		    }
		    else  if(command.equals("/delete.mv")) {
		    	mCommand = new MDeleteCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "list.mv";
		    }
		    else  if(command.equals("/update.mv")) {
		    	mCommand = new MUpdateCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "list.mv";
		  
		    }
		    else  if(command.equals("/id.mv")) {
		    	mCommand = new MIdCommand();
		    	mCommand.execute(request,response);
		    	String data = (String) request.getAttribute("data");
		    	response.getWriter().print(data);
		    	viewPage = "updateForm.jsp";
		  
		    }
		    else  if(command.equals("/updateForm.mv")) {
		    
		    	mCommand = new MUpdateFormCommand();
		    	mCommand.execute(request,response);
		    	viewPage = "updateForm.jsp";
		    	
		    	
		    }
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}


}
