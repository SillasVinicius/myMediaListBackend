package com.sd.myMediaList.Exceptions;

public class TipoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TipoNotFoundException(String mensagem) {
        super(mensagem);
    }

    public TipoNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
