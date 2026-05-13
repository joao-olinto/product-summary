package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.entities.Product;

public class ProductFileReader {

	/*
	 * Here we have our class responsible for reading the text file and returning a
	 * list.
	 */

	// Returns a list of products.
	public List<Product> readerFiles(File arquivoText) {

		List<Product> products = new ArrayList<>();

		// "try-with-resources" ensures that open resources are automatically closed.
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoText))) {

			String text;

			// Repeats as long as there are blocks of characters to be read.
			while ((text = br.readLine()) != null) {

				// handle format errors
				try {
					String[] fields = text.split(",");

					// dealing with dirty lines
					if (fields.length < 3) {
						System.out.println("Invalid line: " + text);

						// interrupts execution and moves to the next line.
						continue;
					}

					//assigns the string values ​​from the fields array to the variables
					String nameProduct = fields[0];
					double priceProduct = Double.parseDouble(fields[1]);
					int quantityProduct = Integer.parseInt(fields[2]);

					//instantiates the product object and adds it to the list.
					products.add(new Product(nameProduct, priceProduct, quantityProduct));

				} catch (NumberFormatException e) {
					System.out.println("Format Error: " + e.getMessage());
					e.printStackTrace();
				}

			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			e.printStackTrace();
		}

		return products;
	}
}
