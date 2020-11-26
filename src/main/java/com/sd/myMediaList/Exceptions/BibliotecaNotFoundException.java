package com.sd.myMediaList.Exceptions;

public class BibliotecaNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public BibliotecaNotFoundException(String mensagem) {
        super(mensagem);
    }

    public BibliotecaNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
