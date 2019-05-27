package datahandle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import exceptions.TypeException;
import exceptions.UnuniqueRecipeName;
import recipe.Recipe;
import recipe.Type;


/* "Кладовщик" - Класс-обертка для изоляции реализации хранилища и методов работы с данными.
 *  Содержит открытые методы для сохранения/загрузки рецептов, получения списков имен рецептов отобранных по типу,
 *  получения массивов Recipe по типу*/

public abstract class Storekeeper {
	
	
	//--------------------------------------------------------------------
	public static void addRecipe ( Recipe r ) throws FileNotFoundException, IOException, UnuniqueRecipeName {
		Worker.saveRecipe( r );
	}
	
	
	//--------------------------------------------------------------------
	public static Recipe getRecipe( String name ) throws FileNotFoundException, ClassNotFoundException, IOException {
		/*Возвращает рецепт по имени рецепта*/
		
		return Worker.loadRecipe( name );
	}
	
	
	//--------------------------------------------------------------------
	public static Recipe[] getRecipes( Type type ) throws FileNotFoundException, ClassNotFoundException, IOException, TypeException{
			/*Возвращает все рецепты заданного типа блюда*/
			
			RecipeList allRecipes = Worker.getRecipeList();
			String[] recipeNames = allRecipes.getRecipeNameList( type );
			
			ArrayList< Recipe > list = new ArrayList< Recipe >();
			for(String name : recipeNames) {
				list.add(Worker.loadRecipe( name ));
			}
			return list.toArray( new Recipe[] {} );
		}
	
	
	//--------------------------------------------------------------------
	public static Set<Type> getUsedTypes() {
		/*Возвращает сет типов рецептов, имеющихся в базе.*/
		
		RecipeList list = Worker.getRecipeList();
		return list.getTypesSet();
	}
	
	
//	//--------------------------------------------------------------------
//	public HashMap<Type, ArrayList<Recipe>> getAllRecipes(){
//		return null;
//	}
//	
//	
	
	/**********************************************
	 * Данный метод только на период разработки!***
	 * ********************************************
	 */
	//--------------------------------------------------------------------
	public static RecipeList getRecipeList(){
		return Worker.getRecipeList();
	}
	
		
	//--------------------------------------------------------------------
	public static String[] getRecipeNameList( Type type ) throws TypeException{
		/*Возвращает список рецептов заданного типа блюда*/
		
		return Worker.getRecipeList().getRecipeNameList( type );
	}
		
}
