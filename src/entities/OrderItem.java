package entities;

public class OrderItem {
	
	private Integer quantity;
	
	// associations (compositions)
	private Product product;
	
	// constructors
	public OrderItem() {
	}
	
	public OrderItem(Product product, Integer quantity) {
		this.quantity = quantity;
		this.product = product;
	}
	
	// getters and setters
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	// class methods
	public Double subTotal() {
		return product.getPrice() * quantity;
	}
}
