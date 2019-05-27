package ui;

/*Действие при завершении программы*/
public class BayBayAction implements Action {

	@Override
	public boolean start() {
		Util.println("До скорых встреч!");
		System.exit(1);
		return true;
	}

}
