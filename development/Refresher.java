package development;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

import datahandle.Storekeeper;
import exceptions.TypeException;
import exceptions.UnuniqueRecipeName;
import recipe.Recipe;
import recipe.Type;

public class Refresher {

	
	
	
	public static void main(String[] args) throws IOException, UnuniqueRecipeName, TypeException {
		//��������� ���� ��������� �� ����� "C:\\Javast\\CookAdvicer\\�����.txt"
		//( ������� .rcp � ��������� ������ � RecipeList)
//		Parser p = new Parser();
//		Recipe[] recipes = p.makeRecipesFromFile();
//		for(Recipe r : recipes ) {
//			Storekeeper.addRecipe( r );
//		}
//		
//		//������ ����� ��� ���� � RecipeList
//		Set<Type> types = Storekeeper.getUsedTypes();
//		for(Type t : types) {
//			System.out.println(t + ":");
//			String[] names = Storekeeper.getRecipeNameList(t);
//			System.out.println(Arrays.toString(names));
//		}
		
//		System.out.println(Storekeeper.getRecipeList());
	}

}
