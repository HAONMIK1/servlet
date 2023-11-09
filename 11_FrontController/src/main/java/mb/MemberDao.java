package mb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private static MemberDao instance = new MemberDao();

	private MemberDao(){
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

	public static MemberDao getInstance() {

		return instance;
	}

	public void insertMember(String id, String passwd, String name) {
		String sql = "insert into member(num,id,passwd,name) values(m_seq.nextval,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) 
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//insertMember=>MInsertCommand

	public ArrayList<MemberBean> getAllMember() {
		ArrayList<MemberBean> list = new ArrayList<MemberBean>(); 

		String sql="select * from member order by num";

		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();

			while(rs.next()) {

				MemberBean mb = new MemberBean();
				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name")); 
				mb.setPasswd(rs.getString("passwd")); 
				mb.setRegister(rs.getString("register")); 

				list.add(mb);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) 
					ps.close();
				if(rs!=null) 
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}//getAllMember=>

	public void deleteMember(String num) {
		String sql = "delete from member where num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) 
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void updateMember(MemberBean mb) {
		String sql = "update member set id =? ,name=? ,passwd = ? , register = sysdate where num = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setString(3, mb.getPasswd());
			ps.setInt(4, mb.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) 
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public MemberBean getOneMember(int num) {
		String sql="select * from member where num = ?";

		MemberBean mb = new MemberBean();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs= ps.executeQuery();

			if(rs.next()) {

				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setName(rs.getString("name")); 
				mb.setPasswd(rs.getString("passwd")); 
				mb.setRegister(rs.getString("register")); 

			}
		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) 
					ps.close();
				if(rs!=null) 
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mb;
	}
}







