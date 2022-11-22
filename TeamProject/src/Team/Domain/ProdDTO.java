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
	
	public ProdDTO(String prodname, int prodamount, int price)
	{
		this.prodName = prodname;
		this.prodAmount = prodamount;
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
		return "[상품코드 : " + prodCode + " | 상품명 : " + prodName + " | 상품재고 : " + prodAmount + " | 소비자가격 : "
				+ price + "]\n";
	}

}
