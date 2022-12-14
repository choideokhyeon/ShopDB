package Team.Domain;

import java.sql.*;
import java.util.ArrayList;

public class MemDAO {
	String id = "SYSTEM";
	String pw = "1234";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//DB연결객체 관련 참조변수
	Connection conn = null;				//DB연결객체용
	PreparedStatement pstmt = null;		//SQL쿼리 전송용 객체
	ResultSet rs = null;				//쿼리결과(Select결과) 수신용
	
	private static MemDAO instance;
	public static MemDAO getInstance()
	{
		if(instance == null)
			instance = new MemDAO();
		return instance;
	}
	
	public MemDAO()
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
	
	public int Insert(MemDTO dto)
	{
		int result = 0;
		try
		{
			pstmt = conn.prepareStatement("insert into mem_tbl values(?, ?, ?, ?, ?, default, 1, 0)");
			pstmt.setString(1, dto.getID());
			pstmt.setString(2, dto.getPW());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		
		return result;
	}
	
	public MemDTO Select(String id)
	{
		MemDTO dto = null;
		try
		{
			pstmt = conn.prepareStatement("select * from mem_tbl where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					dto = new MemDTO();
					dto.setID(rs.getString(1));
					dto.setPW(rs.getString(2));
					dto.setName(rs.getString(3));
					dto.setAddr(rs.getString(4));
					dto.setPhone(rs.getString(5));
					dto.setJoinDate(rs.getString(6));
					dto.setPerm(rs.getInt(7));
					dto.setLoginstatus(rs.getInt(8));
					System.out.println(dto);
				}
			}
		} catch (Exception e) {e.printStackTrace();}
		finally
		{
			try
			{rs.close(); pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return dto;
	}
	
//	dto.get + column + ();
//	Method method = MemDAO.class.getMethod("get"+column);
//	System.out.println("method :" + method.getName());
	
	public ArrayList<MemDTO> SelectAll()
	{
		ArrayList<MemDTO> list = new ArrayList<>();
		try
		{
			pstmt = conn.prepareStatement("select * from mem_tbl");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				int i = 0;
				while(rs.next())
				{
					MemDTO dto = new MemDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
					list.add(dto);
					list.get(i);
					System.out.println();
					i++;
					if(rs.getString(1) == null)
						break;
				}
			}
		} catch (Exception e) { e.printStackTrace();}
		finally
		{
			try
			{rs.close(); pstmt.close();}catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
}
