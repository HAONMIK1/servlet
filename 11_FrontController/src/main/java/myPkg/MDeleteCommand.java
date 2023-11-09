package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mb.MemberDao;

public class MDeleteCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String	num = request.getParameter("num");
		MemberDao dao= MemberDao.getInstance();
		dao.deleteMember(num);
	}

}
