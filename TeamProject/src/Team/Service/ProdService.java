package Team.Service;

import Team.Domain.DTO;
import Team.Domain.ProdDAO;
import Team.Domain.ProdDTO;

public class ProdService {
	
	private ProdDAO pdao = ProdDAO.getInstance();
	
	public ProdService() {}
	
	public boolean RegisterProd(ProdDTO dto)
	{
//		boolean isRegisterOK = true;
		
		int result = pdao.Insert(dto);
		if(result > 0)
			return true;
		return false;
	}
	
	public boolean UpdateProd(int prodcode, int pamount, int price)
	{
		ProdDTO PDTO = pdao.Select(prodcode);
		if(pdao.Select(prodcode).getProdName() != null)
		{
			pdao.Update(PDTO);
			return true;
		}
		return false;
	}

}
