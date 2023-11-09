package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommand {
	public abstract void execute(HttpServletRequest request, HttpServletResponse response);
	
	int a=1;
	
}
/*
 * 인터페이스 특징
 * 
 * 자식을 여러개 만든다
 * 추상 메서드의 상수만 집합으로 이루어진 클래스
 * implements 추상메서드 구현
 * 
 * */
