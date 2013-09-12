package cse.maven.sample.exception;

public class InvalidBmiPropException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidBmiPropException() {
		super("Invalid id number entered");
	}
}
