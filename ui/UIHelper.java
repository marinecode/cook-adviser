package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import datahandle.Storekeeper;
import exceptions.TypeException;
import recipe.Recipe;
import recipe.Type;

/*Класс отделяющий непосредственный интерфейс от логики. */

public class UIHelper {

	//--------------------------------------------------------------------
	static Type[] getUsedTypes() {
		/*Возвращает массив типов рецептов, имеющихся в базе.*/
		
		Type[] types = Storekeeper.getUsedTypes().toArray( new Type[] {} );
		return types;
	}
	
	
	//--------------------------------------------------------------------
	static String[] getRecipeList( Type type ) {
		String[] names = {};
		try {
			names=Storekeeper.getRecipeNameList(type);
		} catch (TypeException e) {
			
			//Этого никогда не случится, потому что хозяйка выбирает тип из
			//списка типов, которые точно есть. Никакой отсебятины
			e.printStackTrace();
		} 
		
		return names;
	}
	
	
	//--------------------------------------------------------------------
	static Recipe getRecipe( String name ) throws FileNotFoundException, ClassNotFoundException, IOException {
		return Storekeeper.getRecipe( name );
	}
}
