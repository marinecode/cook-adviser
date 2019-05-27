package datahandle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import exceptions.TypeException;
import exceptions.UnuniqueRecipeName;
import recipe.Recipe;
import recipe.Type;


/* "���������" - �����-������� ��� �������� ���������� ��������� � ������� ������ � �������.
 *  �������� �������� ������ ��� ����������/�������� ��������, ��������� ������� ���� �������� ���������� �� ����,
 *  ��������� �������� Recipe �� ����*/

public abstract class Storekeeper {
	
	
	//--------------------------------------------------------------------
	public static void addRecipe ( Recipe r ) throws FileNotFoundException, IOException, UnuniqueRecipeName {
		Worker.saveRecipe( r );
	}
	
	
	//--------------------------------------------------------------------
	public static Recipe getRecipe( String name ) throws FileNotFoundException, ClassNotFoundException, IOException {
		/*���������� ������ �� ����� �������*/
		
		return Worker.loadRecipe( name );
	}
	
	
	//--------------------------------------------------------------------
	public static Recipe[] getRecipes( Type type ) throws FileNotFoundException, ClassNotFoundException, IOException, TypeException{
			/*���������� ��� ������� ��������� ���� �����*/
			
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
		/*���������� ��� ����� ��������, ��������� � ����.*/
		
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
	 * ������ ����� ������ �� ������ ����������!***
	 * ********************************************
	 */
	//--------------------------------------------------------------------
	public static RecipeList getRecipeList(){
		return Worker.getRecipeList();
	}
	
		
	//--------------------------------------------------------------------
	public static String[] getRecipeNameList( Type type ) throws TypeException{
		/*���������� ������ �������� ��������� ���� �����*/
		
		return Worker.getRecipeList().getRecipeNameList( type );
	}
		
}
