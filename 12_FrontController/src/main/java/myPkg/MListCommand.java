package myPkg;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.MovieBean;
import movie.MovieDao;

public class MListCommand implements MovieCommand{
public void execute(HttpServletRequest request, HttpServletResponse response) {
		MovieDao dao = MovieDao.getInstance();
		ArrayList<MovieBean> lists = dao.getAllMovie();
		request.setAttribute("lists", lists);
	}
}
