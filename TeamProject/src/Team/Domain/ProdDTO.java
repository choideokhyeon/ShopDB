package Team.Domain;

public class ProdDTO extends DTO{
	private int prodCode;
	private String prodName;
	private int prodAmount;
	private int price;
	
	public ProdDTO(int prodCode, String prodName, int prodAmount, int price) {
		super();
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.prodAmount = prodAmount;
		this.price = price;
	}
	
	ProdDTO(){}

	public int getProdCode() {
		return prodCode;
	}

	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdAmount() {
		return prodAmount;
	}

	public void setProdAmount(int prodAmount) {
		this.prodAmount = prodAmount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProdDTO [prodCode=" + prodCode + ", prodName=" + prodName + ", prodAmount=" + prodAmount + ", price="
				+ price + "]";
	}

}
