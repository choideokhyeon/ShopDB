package Team.Service;

import Team.Domain.ProdDAO;
import Team.Domain.ProdDTO;

public class ProdService {
	
	private ProdDAO dao = ProdDAO.getInstance();
	
	public ProdService() {}
	
	public boolean RegisterProd(ProdDTO dto)
	{
//		boolean isRegisterOK = true;
		
		int result = dao.Insert(dto);
		if(result > 0)
			return true;
		return false;
	}

}
