package ui;



/*���������� ����������������� ���������� � ���������� ������*/

public class CookAdvicer {
	static String[] startMenu = {
			"� ���� ������, ������ ��� � ���� ����.", 
			"��������, ���-������.",
			"������ ��� � ���� ���� �� ���������.",
			"������ ����� ������."
			};
	
	
	//--------------------------------------------------------------------
	public boolean selectAction() {
		int userInput = 0;
		Util.println("������������, ������� ������������! ��� ���� ������?");
		
		do {
			Util.printNumList(startMenu, "���������� ��������, �������)");
			userInput = Util.getUserInputInt();
		}while( !Util.input�orrect( userInput , startMenu.length));
		
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
