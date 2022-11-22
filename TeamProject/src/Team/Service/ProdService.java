package Team.Service;

import Team.Domain.ProdDAO;
import Team.Domain.ProdDTO;

public class ProdService {
	
	private ProdDAO dao = ProdDAO.getInstance();
	
	public ProdService() {}
	
	public boolean RegisterProd(ProdDTO dto, int permission)
	{
//		boolean isRegisterOK = true;
		
		if(permission >= 2)
		{
			int result = dao.Insert(dto);
			if(result > 0)
				return true;
		}
		return false;
	}

}
