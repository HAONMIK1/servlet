package prd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	private String driver;
    private String url;
    private String user;
    private String password;
    Connection conn=null ;
    PreparedStatement ps=null;
    ResultSet rs =null;
	public ProductDao(String driver, String url, String user, String password) {
		this.driver=driver;
		this.url=url;
		this.user=user;
		this.password=password;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<ProdBean> getAllProd() {
		ArrayList<ProdBean> lists = new ArrayList<ProdBean>();
		String sql = "select * from products";
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				ProdBean pb = new ProdBean();
				pb.setId(rs.getString("id"));
				pb.setName(rs.getString("name"));
				pb.setPrice(rs.getString("price"));
				pb.setRegdate(rs.getString("regdate"));
				lists.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();    
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lists;
	}
	public void insertProd(ProdBean pb) {
		String sql = "insert into products values(seqprd.nextval, ?,?, sysdate) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getPrice());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void deleteProd(String id) {
		String sql = "delete from products where id =? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ProdBean getOneProd(String id) {
		String sql = "select * from products where id =? ";
		ProdBean pb = new ProdBean();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pb.setId(rs.getString("id"));
				pb.setName(rs.getString("name"));
				pb.setPrice(rs.getString("price"));
				pb.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return pb;
	}
	public void updateProd(ProdBean pb) {
		String sql = "update products set name = ?, price = ? where id =? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getPrice());
			ps.setString(3, pb.getId());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
