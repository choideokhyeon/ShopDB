package Team.Main;

import Team.Domain.ProdDAO;

public class Main {

	public static void main(String[] args) {
		ProdDAO dao = new ProdDAO();
		
		System.out.println(dao.SelectAll());

	}

}
