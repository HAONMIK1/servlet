package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mb.MemberBean;
import mb.MemberDao;

public class MUpdateCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberBean  mb =new MemberBean();
			mb.setNum(Integer.parseInt(request.getParameter("num")));
		  mb.setId(request.getParameter("id"));
		  mb.setPasswd(request.getParameter("passwd"));
		  mb.setName(request.getParameter("name")); 
		  MemberDao dao=MemberDao.getInstance();
		   dao.updateMember(mb);
		
	}

}
