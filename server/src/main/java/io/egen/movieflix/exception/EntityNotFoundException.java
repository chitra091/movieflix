package io.egen.movieflix.exception;

public class EntityNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5029789273669339243L;
	public EntityNotFoundException(String message) {
		super(message);
	}

}
