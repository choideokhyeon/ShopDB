package Team.Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdDAO {
	String id = "SYSTEM";
	String pw = "1234";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//DB연결객체 관련 참조변수
	Connection conn = null;				//DB연결객체용
	PreparedStatement pstmt = null;		//SQL쿼리 전송용 객체
	ResultSet rs = null;				//쿼리결과(Select결과) 수신용
	
	private static ProdDAO instance;
	public static ProdDAO getInstance()
	{
		if(instance == null)
			instance = new ProdDAO();
		return instance;
	}
	

	public ProdDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int Insert(ProdDTO dto)
	{
		//pstmt
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement("insert into prod_tbl values(prod_seq.NEXTVAL, ?, ?, ?)");
			pstmt.setString(1, dto.getProdName());
			pstmt.setInt(2, dto.getProdAmount());
			pstmt.setInt(3, dto.getPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		
		return result;
	}
	
	public ArrayList<ProdDTO> SelectAll()
	{
		ArrayList<ProdDTO> list = new ArrayList<>();
		try
		{
			pstmt = conn.prepareStatement("select * from prod_tbl");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				int i = 0;
				while(rs.next())
				{
					ProdDTO dto = new ProdDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
					list.add(dto);
					list.get(i);
					i++;
					if(rs.getInt(1) < 1000)
						break;
				}
			}
		}catch (Exception e) { e.printStackTrace();}
		finally
		{
			try
			{rs.close(); pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return list;
	}
	
	public ProdDTO Select(int prodcode)
	{
		ProdDTO dto = null;
		try
		{
			pstmt = conn.prepareStatement("select * from prod_tbl where prodcode=?");
			pstmt.setInt(1, prodcode);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				rs.next();
				dto = new ProdDTO();
				dto.setProdCode(rs.getInt("prodcode"));
				dto.setProdName(rs.getString("prodname"));
				dto.setProdAmount(rs.getInt("prodamount"));
				dto.setPrice(rs.getInt("price"));
			}
		}catch (Exception e) { e.printStackTrace();}
		finally
		{
			try
			{rs.close(); pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return dto;
	}
	
	public boolean Update(ProdDTO dto)
	{
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement("update prod_tbl set prodamount=?, price=? where prodcode=?");
			pstmt.setInt(1, dto.getProdAmount());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setInt(3, dto.getProdCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();}
		finally
		{
			try
			{pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		if(result > 0)
			return true;
		
		return false;
	}
	
}