package application;

import java.io.File;
import java.util.Locale;
import domain.exception.DomainException;
import domain.service.ProductService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		//// "try-with-resources" ensures that open resources are automatically closed.
		try {

			// instantiates the service class
			ProductService service = new ProductService();
			// String String containing the abstract path to the input file.
			String fileInProducts = "C:\\Users\\O Pai\\OneDrive\\Desktop\\facul ADS\\cursos adicionais\\ws-eclipse\\ProductSumary\\ProdutoData\\Entrada\\lista-produto.txt";
			// Instantiates the object of type File.
			File dataInProducts = new File(fileInProducts);
			// The method responsible for creating the product list.
			service.generateProductList(dataInProducts);
			// A method that returns a string containing a summary of the products in stock.
			String productSummary = service.generateSummary();

			//Abstract path to the CSV file containing the product list.
			String fileoutProducts = "C:\\Users\\O Pai\\OneDrive\\Desktop\\facul ADS\\cursos adicionais\\ws-eclipse\\ProductSumary\\ProdutoData\\Saida";
			//instance of the summary file.
			File summaryProducts = new File(fileoutProducts, "summary-products.csv");
			//A method that saves the product list summary to a CSV file.
			service.saveSummary(summaryProducts, productSummary);
			
		} catch (DomainException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
