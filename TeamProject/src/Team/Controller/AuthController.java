package Team.Controller;

import Team.Domain.DTO;
import Team.Domain.MemDTO;
import Team.Service.AuthService;

public class AuthController implements SubController
{
	
	private AuthService service = AuthService.getInstance();

	@Override
	public Object execute(int SN, DTO dto)
	{
		switch(SN)
		{
			case 1:
				MemDTO down = (MemDTO)dto;
				String id = down.getID();
				String pw = down.getPW();
				if(id != null || pw != null)
					service.LoginCheck(id, pw);
				break;
			case 2:
//				MemDTO down2 = (MemDTO)dto;
//				String id2 = down2.getID();
//				if(id2 != null)
//					service.LogOut(id2);
				break;
		}
		
		return null;
	}
}
