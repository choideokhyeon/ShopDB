package Team.Service;

import java.io.PipedWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.exceptions.RSAException;

import Team.Domain.MemDAO;
import Team.Domain.MemDTO;

public class AuthService {

	private MemDAO dao = MemDAO.getInstance();
	
	private static AuthService instance;
	public static AuthService getInstance()
	{
		if(instance == null)
			instance = new AuthService();
		return instance;
	}
	
	public AuthService() {}

	public Object LoginCheck(String id, String pw)
	{
		MemDTO dto = null;
		dto = dao.Select(id);
		if(dto == null)
		{
			return null;
		}
		
		if(id.equals(dto.getID()) && pw.equals(dto.getPW()))
		{
			return dao.Login(dto);
		}
		
		return null;
	}

}
