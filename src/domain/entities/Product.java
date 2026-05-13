package domain.entities;

import domain.exception.DomainException;

public class Product {

	private String name;
	private double price;
	private int quantity;

	// Constructor overloading for double initialization of objects
	public Product(String name, double price, int quantity) {

		// The attribute name format accepts letters, spaces, and numbers.
		if (name == null || !name.trim().matches("^[\\p{L}\\d\\s-]+$")) {
			throw new DomainException("Domain error: The name is null or out of format.");

		}

		// The attributes "price" and "quantity" cannot be less than zero.
		if (price < 0.0) {
			throw new DomainException("Domain error: the price cannot be lower than zero.");
		}

		if (quantity < 0) {
			throw new DomainException("Domain error: the quantity cannot be lower than zero.");
		}

		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(String name, double price) {

		if (name == null || !name.trim().matches("^[\\p{L}\\d\\s-]+$")) {
			throw new DomainException("Domain error: The name is null or out of format.");

		}

		if (price < 0.0) {
			throw new DomainException("Domain error: the price cannot be lower than zero.");
		}
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}

	// Getters e setters methods with validations
	public String getName() {
		return name;
	}

	public void setName(String name) {

		if (name == null || !name.trim().matches("^[\\p{L}\\d\\s-]+$")) {
			throw new DomainException("Domain error: The name is null or out of format.");

		}

		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {

		if (price < 0.0) {
			throw new DomainException("Domain error: the price cannot be lower than zero.");

		}

		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		
		if(quantity < 0) {
			throw new DomainException("Domain error: the quantity cannot be lower than zero.");
		}
	}
	
	
	//A method that allows us to calculate the subtotal.
	public double subTotal() {
		return price * quantity;
	}

}
