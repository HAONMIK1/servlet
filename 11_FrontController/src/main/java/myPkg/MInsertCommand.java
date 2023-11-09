package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mb.MemberDao;

public class MInsertCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String	id = request.getParameter("id");
		String	passwd = request.getParameter("passwd");
		String	name = request.getParameter("name");
		MemberDao dao= MemberDao.getInstance();
		dao.insertMember(id,passwd,name);
	}
}
