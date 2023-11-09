package myPkg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.MovieBean;
import movie.MovieDao;

public class MIdCommand implements MovieCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MovieDao dao = MovieDao.getInstance();
		String id = request.getParameter("checkId");
		String data =dao.OneIDMovie(id);
		request.setAttribute("data", data);
	}

}
