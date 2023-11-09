package myPkg;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mb.MemberBean;
import mb.MemberDao;

public class MListCommand implements MemberCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			MemberDao dao = MemberDao.getInstance();
			ArrayList<MemberBean> lists = dao.getAllMember();
			request.setAttribute("lists", lists);
	}
}
