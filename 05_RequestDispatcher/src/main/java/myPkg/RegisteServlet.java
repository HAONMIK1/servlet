package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisteServlet
 */
@WebServlet("/rServlet")
public class RegisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		CoffeeBean cb = new CoffeeBean();
		cb.setName(request.getParameter("name"));
		cb.setCoffee(request.getParameter("coffee"));
		String Cname = request.getParameter("name");
		String[] Ccoffee = request.getParameterValues("coffee");
		
		request.setAttribute("cb", cb);
		request.setAttribute("Cname", Cname);
		request.setAttribute("Ccoffee", Ccoffee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("register_result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		String name =request.getParameter("name");
		String age =request.getParameter("age");
		String gender =request.getParameter("gender");
		String[] coffee =request.getParameterValues("coffee");
		String coffeee="";
		for(String i : coffee){
			coffeee+=i+ "";
		}
		request.setAttribute("coffeee", coffeee);
		String job =request.getParameter("job");
		String travel =request.getParameter("travel");
		System.out.print(name+" "+age+" "+gender+" "+coffeee+" "+job+" "+travel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register_result.jsp");
		dispatcher.forward(request, response);
	}

}
