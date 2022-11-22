package Team.Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	

	private ProdDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connected...");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally
		{
			try {conn.close();}
			catch(Exception e) {e.printStackTrace();}
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
	
}