package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.MovieDao;

public class MDeleteCommand implements MovieCommand  {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
			String num = request.getParameter("num");
			MovieDao dao = MovieDao.getInstance();
			dao.deleteMovie(num);
	}
}
