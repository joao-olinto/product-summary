package domain.service;

import java.io.File;
import java.util.List;

import application.ProductFileReader;
import application.ProductFileWriter;
import domain.entities.Product;
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

	// returns the total value of the products in the list
	public double totalValueProducts() {
		double totalValue = 0.0;
		// A foreach loop iterates through the list, adding the value of each product to
		// the variable `totalValue`.
		for (Product p : products) {
			totalValue += p.subTotal();
		}

		return totalValue;
	}

	// method that returns the average of the products in the list.
	public double productsAverage() throws DomainException, ArithmeticException {

		if (products == null || products.isEmpty()) {
			throw new DomainException("Domain Error: the product list is empty."

			);
		}
		double average = totalValueProducts() / products.size();
		return average;
	}

	// Returns the quantity of products in the list.
	public int quantityOfProducts() {

		return products.size();
	}

	// returns a shallow copy of the product list
	public List<Product> getProducts() {

		return List.copyOf(products);
	}
}
