package prd;

public class ProdBean {
	private String id;
	private String name;
	private String price;
	private String regdate;
	public ProdBean(String id, String name, String price, String regdate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.regdate = regdate;
	}
	public ProdBean() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
