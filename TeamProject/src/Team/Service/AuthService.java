package Team.Service;

import Team.Domain.MemDAO;

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

}
