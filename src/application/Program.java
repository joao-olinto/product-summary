package application;

import java.io.File;
import java.util.Locale;

import domain.service.ProductService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		ProductService service = new ProductService();
		String fileInProducts = "C:\\Users\\O Pai\\OneDrive\\Desktop\\facul ADS\\cursos adicionais\\ws-eclipse\\ProductSumary\\ProdutoData\\lista-produto.csv";
		File dataInProducts = new File(fileInProducts);
		service.generateProductList(dataInProducts);
		
		
		

	}

}
