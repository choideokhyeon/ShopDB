package Team.Controller;

import java.util.HashMap;
import java.util.Map;

import Team.Domain.DTO;

public class FrontController {
	
	private final Map<String, SubController> map = new HashMap<>();
	
	public FrontController()
	{
		init();
	}
	
	private final void init()
	{
		map.put("/prod", new ProdController());
		map.put("/mem", new MemController());
		map.put("/auth", new AuthController());
	}
	
	public Object ExSubController(String menu, int SN, DTO dto)
	{
		SubController sub = map.get(menu);
		Object obj = sub.execute(SN,dto);
		
		return obj;
	}
	
}
