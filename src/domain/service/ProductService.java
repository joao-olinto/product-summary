package domain.service;

import java.io.File;
import java.util.List;

import application.ProductFileReader;
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
		double average = totalValueProducts() / products.size();
		return average;
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
