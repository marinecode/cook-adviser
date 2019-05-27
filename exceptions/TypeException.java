package exceptions;

/*Выбрасывается при отсутствии заданного типа в базе данных*/

public class TypeException extends Exception {
	public TypeException (String message) {
		super(message);
	}
}
