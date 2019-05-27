package datahandle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import exceptions.TypeException;
import exceptions.UnuniqueRecipeName;
import recipe.Recipe;
import recipe.Type;

/*Класс контейнер одиночка. Хранит пары значений < тип, список блюд этого типа >. 
 * При нормальной эксплуатации сериализуется из файла recipeList.rcpl*/

public class RecipeList implements Serializable {
		
	private static RecipeList recipeList= new RecipeList();
	private HashMap< Type, ArrayList<String> > allRecipesList = new HashMap< Type, ArrayList<String> >();
	private RecipeList() { };
	
	
	//--------------------------------------------------------------------
	static RecipeList retrieve() {
		return recipeList;
	}
	
	
	//--------------------------------------------------------------------
	void addRecipe( Recipe r ) throws UnuniqueRecipeName {
		/*Добавляет название рецепта в список*/
		if(isRecipeNameUnique(r))
			addRecipeNameToArray(r);
		else throw new UnuniqueRecipeName(r.getName());
	}

	
	//--------------------------------------------------------------------
	String[] getRecipeNameList( Type type ) throws TypeException{
		/*Возвращает список имен рецептов указанного типа*/
		
		String[] recipesList= {};
		try {
			recipesList = allRecipesList.get(type).toArray(new String[] {});
		}
		catch(NullPointerException e) {
			throw new TypeException("Нет рецептов типа "+type);
		}
		return recipesList;
	}
	
	
	//--------------------------------------------------------------------
	Set<String> getAllNamesSet(){
		Set<String> nameSet = new TreeSet<String>();
		for(ArrayList<String> list : allRecipesList.values())
			nameSet.addAll(list);
		return nameSet;
	}
	
	
	//--------------------------------------------------------------------
	Set<Type> getTypesSet(){
		return allRecipesList.keySet();
	}
	
	
	//--------------------------------------------------------------------
	private void addRecipeNameToArray( Recipe r ) {
		Type type = r.getType();
		String name = r.getName();
		
		    //Проверяем есть ли тип этого рецепта в списке
			if(allRecipesList.containsKey( type )) {
				
		        //	Если ДА, добавляем имя рецепта в соответствующий список имен
				allRecipesList.get( type ).add( name );
			}		
			else {
				//Если НЕТ, добавляем новый тип и новый список имен для блюд этого типа
				ArrayList<String> newList = new ArrayList<String>();
				newList.add( name );
				allRecipesList.put( type, newList );
			}	
	}
	
	
	//--------------------------------------------------------------------
	private boolean isRecipeNameUnique( Recipe r ) {
		Set<String> nameSet = getAllNamesSet();
		if(nameSet.contains( r.getName() )) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	//--------------------------------------------------------------------
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		
//		for(Type type : getTypesSet()) {
//			sb.append(type);
//			sb.append(":\n");
//			try {
//				for(String recipeName : getRecipeNameList(type)) {
//					sb.append("\t"+recipeName+ "\n");
//				}
//			} catch (TypeException e) {
//				e.printStackTrace();
//			}
//		}
//		return sb.toString();
//	}
}
