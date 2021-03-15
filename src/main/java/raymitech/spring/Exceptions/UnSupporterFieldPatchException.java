package raymitech.spring.Exceptions;

import java.util.Set;

public class UnSupporterFieldPatchException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnSupporterFieldPatchException(Set<String> keys) {
		super("Campo " + keys.toString() + " no es permitida la modificación.");
	}

	public UnSupporterFieldPatchException() {
		super();
	}

	
}
