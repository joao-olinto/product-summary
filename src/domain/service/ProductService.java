package domain.service;

import java.io.File;
import java.util.List;

import domain.entities.Product;
import application.ProductFileReader;
import application.ProductFileWriter;
import domain.exception.DomainException;

public class ProductService {

	// List of product-type objects.
	private List<Product> products;

	// This method receives a File as a parameter and passes the list to the service
	// class.
	public void generateProductList(File file) {
		ProductFileReader reader = new ProductFileReader();
		products = reader.readFile(file);
	}

	// This method takes as parameters a string and a file that will be saved as a
	// summary of the products.
	public void saveSummary(File file, String saveText) {
		ProductFileWriter writer = new ProductFileWriter();
		writer.writeFileSummary(file, saveText);
	}
	
	//A method that assembles the summary of the product list using StringBuilder.
	public String generateSummary() {
		StringBuilder sb = new StringBuilder();
		
		
		for(Product p: products) {
			sb.append("\nProduct: "+ p.getName())
			.append(String.format(", price: $%.2f", p.getPrice()));
			sb.append(", quantity: " + p.getQuantity());
			sb.append(String.format("\nsubtotal: %.2f", p.subTotal()));
			sb.append(System.lineSeparator());
			
		}
	
		//skip two lines
		for(int i = 0; i < 2; i++) {
			sb.append(System.lineSeparator());
		}
		
		
		sb.append(String.format("Total value of the products: $%.2f",totalValueProducts()));
		sb.append("\nTotal number of products in stock: "+ totalItemsInStock());
		sb.append(String.format("\nAverage price of all products in stock: $%.2f",productsAverage()));
		
		return sb.toString();
	}

	// returns the total value of the products in the list
	public double totalValueProducts() {
		//We apply lambda to solve this method.
		
		double totalValue = products.stream().mapToDouble(Product::subTotal).sum();

		return totalValue;
	}

	// method that returns the average of the products in the list.
	public double productsAverage() throws DomainException {

		if (products == null || products.isEmpty()) {
			throw new DomainException("Domain Error: the product list is empty."

			);
		}
		
		
		return totalValueProducts() / totalItemsInStock();
	}

	// Returns the quantity of products in the list.
	public int totalItemsInStock() {
		
		// We apply lambda to solve this method.
		int totalQuantityProducts = products.stream()
				// Pega cada produto e transforma em int.
				//Product::getQuantity faz referencia ao metodo
				.mapToInt(Product::getQuantity)
				// Soma tudo automaticamente
				.sum();

		return totalQuantityProducts;
	}

	// returns a shallow copy of the product list
	public List<Product> getProducts() {

		return List.copyOf(products);
	}
}
