package cubes.main.rest;

public class NullCategoryException extends RuntimeException{
	
	public NullCategoryException() {
	super("doslo je do problema sa ucitavanjem kategorije.");	
	}
	
	public NullCategoryException(String message) {
		super(message);
	}

}
