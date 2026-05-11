package domain.exception;

public class DomainException extends RuntimeException {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Criamos a classe para exceções do dominio.
	 * Criamos o construtor e passamos como parametro uma variavel String
	 * Fizemos a chamada ao construtor da superClasse RuntimeException
	 */
	
	public DomainException(String message) {
		super(message);
	}
}
