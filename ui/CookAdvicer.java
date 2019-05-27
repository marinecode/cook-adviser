package ui;



/*Реализация пользовательского интерфейса в коммандной строке*/

public class CookAdvicer {
	static String[] startMenu = {
			"Я сама выберу, покажи что у тебя есть.", 
			"Подскажи, что-нибудь.",
			"Смотри что у меня есть из продуктов.",
			"Добавь новый рецепт."
			};
	
	
	//--------------------------------------------------------------------
	public boolean selectAction() {
		int userInput = 0;
		Util.println("Здравствуйте, Татьяна Владимировна! Чем могу помочь?");
		
		do {
			Util.printNumList(startMenu, "Передумала готовить, отдыхай)");
			userInput = Util.getUserInputInt();
		}while( !Util.inputСorrect( userInput , startMenu.length));
		
		Action selectedAction;
		switch ( userInput ) {
			case 1 : selectedAction = new SelfDecisionAction();
				break;
			case 2 : selectedAction = null;	
				break;
			case 3 : selectedAction = null;	
				break;
			case 4 : selectedAction = null;	
				break;
			case 0 : selectedAction = new BayBayAction();
				break;
			default: selectedAction = null;	
		}
		boolean succses = selectedAction.start();	
		return succses;
	}
	
			
	//--------------------------------------------------------------------
	public static void main ( String[] arg) {
		CookAdvicer ca = new CookAdvicer();
		boolean succses = false;
		do {
			succses = ca.selectAction();
		}while(!succses);
		new BayBayAction().start();
	}
}
