package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.MovieBean;
import movie.MovieDao;

public class MUpdateFormCommand implements MovieCommand {
public void execute(HttpServletRequest request, HttpServletResponse response) {
	String num = request.getParameter("num");
	MovieDao dao = MovieDao.getInstance();
	MovieBean mb= dao.OneMovie(num);
	request.setAttribute("mb", mb);
	}
}
