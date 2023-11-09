package myPkg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
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
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		 String uri = request.getRequestURI();
	     StringBuffer url = request.getRequestURL();
	     String conPath = request.getContextPath();
	     int len = conPath.length();
	     String command = uri.substring(len);
		String viewPage ="result.jsp";
		MemberDao dao = new MemberDao();
		
		if(command.equals("/insert.mb")) {
			MemberBean mb =new MemberBean();
			mb.setName(request.getParameter("name"));
			mb.setPassword(request.getParameter("password"));
			int cnt =dao.insertMember(mb);
			
		}else if(command.equals("/updateForm.mb")) {
			System.out.println("update.mb 요청");
			String id =request.getParameter("id");
			MemberBean mb=dao.getOneSelect(id);
			
			request.setAttribute("mb", mb);
			viewPage = "updateForm.jsp";
			
		}else if(command.equals("/update.mb")) {
			System.out.println("update.mb 요청");
			MemberBean mb = new MemberBean();
			
			mb.setId(request.getParameter("id"));
			mb.setName(request.getParameter("name"));
			mb.setPassword(request.getParameter("password"));
			
			dao.updateMember(mb);
			viewPage = "/select.mb";
			
		}else if(command.equals("/delete.mb")) {
			System.out.println("delete.mb 요청");
			String id =request.getParameter("id");
			dao.deleteMember(id);
			viewPage = "/select.mb";
			
		}else if(command.equals("/select.mb")) {
			System.out.println("select.mb 요청");
			
			ArrayList<MemberBean> list =dao.getAllMember();
			viewPage = "list.jsp";
			request.setAttribute("list", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
