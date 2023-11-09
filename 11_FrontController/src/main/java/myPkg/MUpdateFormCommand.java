package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mb.MemberBean;
import mb.MemberDao;

public class MUpdateFormCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDao dao= MemberDao.getInstance(); 
		MemberBean  mb = dao.getOneMember(num);
		request.setAttribute("mb", mb);
		
	}

}
