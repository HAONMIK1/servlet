package suv;

import java.io.IOException;
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
 * Servlet implementation class SurveyController
 */
//@WebServlet("/SurveyController")
public class SurveyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String driver;
     private String url;
     private String user;
     private String password;
     ServletContext sc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        
         sc = config.getServletContext();
        driver = config.getInitParameter("driver");
        url = config.getInitParameter("url");
        user = config.getInitParameter("user");
        password = config.getInitParameter("password");
        SurveyDAO dao = new SurveyDAO(driver,url,user,password);
     }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri= request.getRequestURI();
		String path =request.getContextPath();
		int len = path.length();
		String command=uri.substring(len);
		
		String viewPage = "";
	    SurveyDAO dao = new SurveyDAO(driver,url,user,password);
	    
	    if(command.equals("/list.sv")) {
	    	ArrayList<SurveyBean> lists = dao.selectSurv();
	    	System.out.println("lists.size()"+lists.size());
	    	request.setAttribute("lists", lists);
	    	viewPage="list.jsp";
	    }
	    else  if(command.equals("/insert.sv")) {
	    	Boolean flag = (boolean)sc.getAttribute("flag");
	    	if(flag==false) {
	    		
	    	SurveyBean sb = new SurveyBean();
	    	sb.setName(request.getParameter("name"));
	    	sb.setCompany(request.getParameter("company"));
	    	sb.setEmail(request.getParameter("email"));
	    	sb.setSatisfaction(request.getParameter("satisfaction"));
	    	String part="";
	    	if(request.getParameterValues("part")==(null)) {
	    			part="선택 안함";
	    	}
	    	else {
	    	String [] parts = request.getParameterValues("part");
	    	for(String i : parts) {
	    		part += i + " ";
	    	}
	    	}
	    	sb.setPart(part);
	    	sb.setHowto(request.getParameter("howto"));
	    	sb.setAgree(request.getParameter("agree"));
	    	dao.insertSurv(sb );
	    	viewPage="/list.sv";
	    	}else {
	    		viewPage="/list.sv";
	    	}
	    }
	    else  if(command.equals("/delete.sv")) {
	    	String no = request.getParameter("no");
	    	dao.deleteSurv(no);
	    	viewPage="/list.sv";
	    }
	    else  if(command.equals("/update.sv")) {
	    	SurveyBean sb = new SurveyBean();
	    	sb.setNo(request.getParameter("no"));
	    	sb.setName(request.getParameter("name"));
	    	sb.setCompany(request.getParameter("company"));
	    	sb.setEmail(request.getParameter("email"));
	    	sb.setSatisfaction(request.getParameter("satisfaction"));
	    	String part="";
	    	if(request.getParameterValues("part")==(null)) {
	    			part="선택 안함";
	    	}
	    	else {
	    	String [] parts = request.getParameterValues("part");
	    	for(String i : parts) {
	    		part += i + " ";
	    	}
	    	}
	    	sb.setPart(part);
	    	sb.setHowto(request.getParameter("howto"));
	    	sb.setAgree(request.getParameter("agree"));
	    	dao.updateSurv(sb);
	    	viewPage="/list.sv";
	    }
	    else  if(command.equals("/updateForm.sv")) {
	    	String no = request.getParameter("no");
	    	SurveyBean sb = dao.getOneSurv(no);
	    	request.setAttribute("sb", sb);
	    	viewPage="updateForm.jsp";
	    }
	    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	    dispatcher.forward(request, response);
	}
}
