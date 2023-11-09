package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MovieDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static MovieDao instance = new MovieDao();

	private MovieDao(){
		Context initContext;
		try {
			initContext = new InitialContext();

			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//MemberDao

	public static MovieDao getInstance() {

		return instance;
	}

	public void InsertMovie(MovieBean mb) {
		String sql = "insert into movie(num,id,name,age,genre,time,partner,memo) values(mv_seq.nextval,?,?,?,?,?,?,?)";
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setInt(3, mb.getAge());
			ps.setString(4, mb.getGenre());
			ps.setString(5, mb.getTime());
			ps.setInt(6, mb.getPartner());
			ps.setString(7, mb.getMemo());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}

	public ArrayList<MovieBean> getAllMovie() {
		ArrayList<MovieBean> lists = new ArrayList<MovieBean>();
		String sql ="select * from movie";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieBean mv =new MovieBean();
				mv.setNum(rs.getInt("num"));
				mv.setId(rs.getString("id"));
				mv.setName(rs.getString("name"));
				mv.setAge(rs.getInt("age"));
				mv.setGenre(rs.getString("genre"));
				mv.setTime(rs.getString("time"));
				mv.setPartner(rs.getInt("partner"));
				mv.setMemo(rs.getString("memo"));
				lists.add(mv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return lists;
	}

	public void deleteMovie(String num) {
		String sql = "delete from movie where num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,num);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}	
	public void UpdateMovie(MovieBean mb) {
		String sql = "update movie set id = ?, name = ?, age = ? ,genre = ?,time = ? , partner = ?, memo = ? where num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setInt(3, mb.getAge());
			ps.setString(4, mb.getGenre());
			ps.setString(5, mb.getTime());
			ps.setInt(6, mb.getPartner());
			ps.setString(7, mb.getMemo());
			ps.setInt(8, mb.getNum());
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
	}

	public MovieBean OneMovie(String num) {
		String sql ="select * from movie where num = ?";
		MovieBean mv =new MovieBean();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while(rs.next()) {
				mv.setNum(rs.getInt("num"));
				mv.setId(rs.getString("id"));
				mv.setName(rs.getString("name"));
				mv.setAge(rs.getInt("age"));
				mv.setGenre(rs.getString("genre"));
				mv.setTime(rs.getString("time"));
				mv.setPartner(rs.getInt("partner"));
				mv.setMemo(rs.getString("memo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return mv ;
		
	}

	public String OneIDMovie(String id) {
		String sql ="select * from movie where id = ?";
		String result= "YES";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				result= "NO";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
		
	}
	
	
}
