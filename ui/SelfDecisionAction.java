package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import recipe.Recipe;
import recipe.Type;

	/*�������� ��� ���������������� ������ ������� �� ������*/

public class SelfDecisionAction implements Action{

	
	//--------------------------------------------------------------------
	public boolean start() {
		/*�������� ���� ������� ����� ������� ���� �� ������ ��������*/
			
		Util.println("��� ����� ��������?");
		Recipe recipe;
		
		/*������� �������� ��� ����� � ������ �� ����������� ��������������� �������.
		 * ����� ������������ null ��� ������ ��� ������������ ����� ���������
		 * �� ���������� ���.*/
		do {
		Type type = selectType();
			if( type == null ) {
				return false;
			}
		recipe = selectRecipe( type );
		}while( recipe == null );
		
		// TODO ��������� ���������� ��������. � ����� ������� ���� �������� ���� ������������� � �������� �������
		return true;
	}	
	
		
	//--------------------------------------------------------------------
	private Type selectType() {
		/*������� �������� ��� �����, ������� ���������� ��������,
		 *�� ������ �����, ������� ������� ��� � ����.*/
			
		Type[] types = UIHelper.getUsedTypes();
		int input;
		do {
			Util.printNumList(types);
			input =Util.getUserInputInt();
		}while( !Util.input�orrect( input, types.length ) );
		
		Type selectedType = null;
		
		// ��� ����� 0, ��������� ������������ �� ���������� ���.
		//� ������ ������ � ���������� ������ (����� ��������) 
		if(input == 0) {
			return selectedType;
		}
		
		selectedType = types[ input-1 ];
		return selectedType;
	}
	
	
	//--------------------------------------------------------------------
	private Recipe selectRecipe( Type type ) {
		/*������� �������� ����� �� ������ ���� ������ ����*/
		
		String[] recipesNames = UIHelper.getRecipeList( type );
		int input = 0;
		
		//���������� ����������� �����. ���������� �������� recipesNames.length >= input >=0
		do {
			Util.printNumList( recipesNames );
			input = Util.getUserInputInt(); //  recipesNames.length >= input >=0		
		}while(!Util.input�orrect( input, recipesNames.length ));
		
		Recipe selectedRecipe = null;
		// ��� ����� 0, ��������� ������������ �� ���������� ���. � ������ ������ �� ����� ���� ����� 
		if( input == 0 ) {
			return selectedRecipe;
		}
		
		//������� ��������� ������ �� ����� �� ���� ������
		String nameOfSelectedRecipe="";
		try {
			nameOfSelectedRecipe = recipesNames[ input-1 ];
			selectedRecipe = UIHelper.getRecipe( nameOfSelectedRecipe );
			
		}catch (FileNotFoundException e) {
			//��������� ������� ������ ������
			
			Util.println( "���� " + nameOfSelectedRecipe  + ".rcp �� ������( ��������� ��� �� ������?\n" );
			selectedRecipe = selectRecipe( type );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedRecipe;
	}
			
}
