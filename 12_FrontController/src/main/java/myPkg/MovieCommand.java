package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MovieCommand {
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
}
