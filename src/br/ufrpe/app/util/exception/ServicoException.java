package br.ufrpe.app.util.exception;

public class ServicoException extends Exception{

	private static final long serialVersionUID = 1L;

	public ServicoException(String message) {
		super("Serviço já cadastrado! Procure no sistema ou cadastre outro.");
	}
	
	

}
