package prd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productController
 */
/* @WebServlet("/productController") */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private String driver;
      private String url;
      private String user;
      private String password;
      ServletContext sc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        
         sc = config.getServletContext();
        driver = config.getInitParameter("driver");
        url = config.getInitParameter("url");
        user = config.getInitParameter("user");
        password = config.getInitParameter("password");
        ProductDao dao = new ProductDao(driver,url,user,password);
     }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String conpath = request.getContextPath();
		int len = conpath.length();
		String command =uri.substring(len);
		String viewPage ="list.jsp";
		ProductDao dao = new ProductDao(driver,this.url,user,password);
			
		if(command.equals("/insert.prd")) {
			boolean flag = (Boolean)sc.getAttribute("flag");
			if(flag == false) { // 
				String name = request.getParameter("name");
				System.out.println("name:" + name);
				String price = request.getParameter("price");
				ProdBean pb = new ProdBean(null, name, price, null);
				dao.insertProd(pb);
				sc.setAttribute("flag", true);
				viewPage = "list.prd";
				
			}else {
				viewPage = "list.prd";
			}	
		}else if(command.equals("/update.prd")) {
			ProdBean pb = new ProdBean();
			pb.setId(request.getParameter("id"));
			pb.setName(request.getParameter("name"));
			pb.setPrice(request.getParameter("price"));
			dao.updateProd(pb);
		}else if(command.equals("/updateForm.prd")) {
			String id = request.getParameter("id");
			ProdBean pb =dao.getOneProd(id);
			request.setAttribute("pb", pb);
			viewPage = "updateForm.jsp";
			
		}else if(command.equals("/delete.prd")) {
			String id = request.getParameter("id");
			dao.deleteProd(id);
		}
		
		ArrayList<ProdBean> lists = dao.getAllProd();
		request.setAttribute("lists", lists);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
