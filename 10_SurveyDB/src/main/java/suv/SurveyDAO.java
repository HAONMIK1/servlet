package suv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SurveyDAO {
	private String driver;
    private String url;
    private String user;
    private String password;
    
    Connection conn=null ;
    PreparedStatement ps=null;
    ResultSet rs =null;
    
	public SurveyDAO(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		try {
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,password);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ArrayList<SurveyBean> selectSurv() {
		
		ArrayList<SurveyBean> lists = new ArrayList<SurveyBean>();
		
		try {
			String sql = "select * from survey";
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				SurveyBean sb = new SurveyBean();
				
				sb.setNo(rs.getString("no"));
				sb.setName(rs.getString("name"));
				sb.setCompany(rs.getString("company"));
				sb.setEmail(rs.getString("email"));
				sb.setSatisfaction(rs.getString("satisfaction"));
				sb.setPart(rs.getString("part"));
				sb.setHowto(rs.getString("howto"));
				sb.setAgree(rs.getString("agree"));
				
				lists.add(sb);
				System.out.println("lists.size()"+lists.size());
			}
		}catch (Exception e) {
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
	public void insertSurv(SurveyBean sv) {
		String sql = "insert into survey values(seqmy.nextval,?,?,?,?,?,?,?)";
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, sv.getName());
			ps.setString(2, sv.getCompany());
			ps.setString(3, sv.getEmail());
			ps.setString(4, sv.getSatisfaction());
			ps.setString(5, sv.getPart());
			ps.setString(6, sv.getHowto());
			ps.setString(7, sv.getAgree());
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
	public void deleteSurv(String no) {
		String sql = "delete from survey where no = ?";
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, no);
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
	public void updateSurv(SurveyBean sb) {
		String sql = "update survey set name =?,company =? ,email =? ,satisfaction =? ,part =? , howto = ? , agree = ? where no = ?";
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getCompany());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getSatisfaction());
			ps.setString(5, sb.getPart());
			ps.setString(6, sb.getHowto());
			ps.setString(7, sb.getAgree());
			ps.setString(8, sb.getNo());
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
	public SurveyBean getOneSurv(String no) {
		SurveyBean sb = new SurveyBean();
		String sql = "select * from survey where no = ?";
		try {
			ps =conn.prepareStatement(sql);
			ps.setString(1, no);
			rs=ps.executeQuery();
			if(rs.next()) {
				sb.setNo(rs.getString("no"));
				sb.setName(rs.getString("name"));
				sb.setCompany(rs.getString("company"));
				sb.setEmail(rs.getString("email"));
				sb.setSatisfaction(rs.getString("satisfaction"));
				sb.setPart(rs.getString("part"));
				sb.setHowto(rs.getString("howto"));
				sb.setAgree(rs.getString("agree"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				ps.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return sb;
	}
}
