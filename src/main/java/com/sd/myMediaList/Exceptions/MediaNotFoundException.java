package com.sd.myMediaList.Exceptions;

public class MediaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MediaNotFoundException(String mensagem) {
        super(mensagem);
    }

    public MediaNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
