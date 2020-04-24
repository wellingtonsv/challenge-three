package game.exception;

public class ErroIntenoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroIntenoException() {
		super();
	}

	public ErroIntenoException(final String msg) {
		super(msg);
	}
	
	public ErroIntenoException(Throwable t) {
		super(t);
	}
	
	public ErroIntenoException(final String msg,Throwable t) {
		super(msg, t);
	}
}
