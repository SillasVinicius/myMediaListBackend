package com.sd.myMediaList.Exceptions;

public class StatusNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StatusNotFoundException(String mensagem) {
        super(mensagem);
    }

    public StatusNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
