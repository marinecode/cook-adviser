package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import datahandle.Storekeeper;
import exceptions.TypeException;
import recipe.Recipe;
import recipe.Type;

/*����� ���������� ���������������� ��������� �� ������. */

public class UIHelper {

	//--------------------------------------------------------------------
	static Type[] getUsedTypes() {
		/*���������� ������ ����� ��������, ��������� � ����.*/
		
		Type[] types = Storekeeper.getUsedTypes().toArray( new Type[] {} );
		return types;
	}
	
	
	//--------------------------------------------------------------------
	static String[] getRecipeList( Type type ) {
		String[] names = {};
		try {
			names=Storekeeper.getRecipeNameList(type);
		} catch (TypeException e) {
			
			//����� ������� �� ��������, ������ ��� ������� �������� ��� ��
			//������ �����, ������� ����� ����. ������� ����������
			e.printStackTrace();
		} 
		
		return names;
	}
	
	
	//--------------------------------------------------------------------
	static Recipe getRecipe( String name ) throws FileNotFoundException, ClassNotFoundException, IOException {
		return Storekeeper.getRecipe( name );
	}
}
