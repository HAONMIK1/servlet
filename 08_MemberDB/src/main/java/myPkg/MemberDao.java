package myPkg;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	Connection conn=null;
	ResultSet rs =null;
	PreparedStatement ps =null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid="kim";
	String dbpw="1234";
	public MemberDao() {
	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url,dbid,dbpw);
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }//MemberDao
	public int insertMember(MemberBean mb)  {
		int cnt =0;
		String sql = "insert into member values(seqmem.nextval, ?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,mb.getName() );
			ps.setString(2,mb.getPassword() );
			cnt =ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return cnt;
	}
	public ArrayList<MemberBean> getAllMember() {
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		String sql = "select  * from member";
		try {
		ps= conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while (rs.next()) {
			MemberBean mb =new MemberBean();
			mb.setId(rs.getString("id"));
			mb.setName(rs.getString("name"));
			mb.setPassword(rs.getString("password"));
			list.add(mb);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}	finally {
			try {
				ps.close();
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}	
		return list;
	}
	public int deletMember(String id)  {
		int cnt =0;
		String sql = "delete from member where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			cnt =ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return cnt;
	}
	public int updateMember(String id)  {
		int cnt =0;
		String sql = "update member set where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			cnt =ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return cnt;
	}
}
