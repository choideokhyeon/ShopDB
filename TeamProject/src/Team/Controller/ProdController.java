package Team.Controller;

import Team.Domain.DTO;
import Team.Domain.ProdDTO;
import Team.Service.ProdService;

public class ProdController implements SubController{
	
	ProdService service = new ProdService();

	@Override
	public Object execute(int SN, DTO dto) {
		Object obj = null;
		boolean flag = false;
		switch(SN)
		{
			case 1:	//상품 등록
				ProdDTO down = (ProdDTO)dto;
				flag = service.RegisterProd(down, 2);
				if(flag)
					obj = "[SYSTEM]상품 등록에 성공했습니다";
				else
					obj = "[SYSTEM]상품 등록에 실패했습니다";
		}
		
		return null;
	}

}
