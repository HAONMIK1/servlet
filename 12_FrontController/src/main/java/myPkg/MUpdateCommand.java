package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.MovieBean;
import movie.MovieDao;

public class MUpdateCommand implements MovieCommand{
public void execute(HttpServletRequest request, HttpServletResponse response) {
	MovieDao dao = MovieDao.getInstance();
	MovieBean mb = new MovieBean();
	mb.setNum(Integer.parseInt(request.getParameter("num")));
	mb.setId(request.getParameter("id"));
	mb.setAge(Integer.parseInt(request.getParameter("age")));
	String[] genres = request.getParameterValues("genre");
	String genre="";
	for(String i :genres) {
		genre += i+" ";
	}
	mb.setGenre(genre);
	mb.setMemo(request.getParameter("memo"));
	mb.setName(request.getParameter("name"));
	mb.setPartner(Integer.parseInt(request.getParameter("partner")));
	mb.setTime(request.getParameter("time"));
	dao.UpdateMovie(mb);
	request.setAttribute("mb", mb);
	}
}
