package datahandle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import exceptions.UnuniqueRecipeName;
import recipe.Recipe;
import recipe.Type;


/*"Рабочий" - имеет дело непосредственно с сериализацией */

public class Worker {
		
	private static RecipeList recipeList;
	private static final String STORAGE = "C:\\Javast\\CookAdvicer\\dataForTests\\";
	private static final String RECIPE_FORMAT = ".rcp";
	private static final String RECIPE_LIST_FORMAT = ".rcpl";
	
	//В статическом блоке загружается recipeList
	static {
		try {
			recipeList = loadRecipeList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidClassException e) {
			//Десериализуемый класс устарел. Получим актуальную версию и сериализуем её.
			//                !!! Полученная версия листа ПУСТАЯ!!!
			//Эта ошибка не может возникнуть во время эксплуатации. Возникнет только во время разработки.
			recipeList = RecipeList.retrieve();
			try {
				saveRecipeList();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private Worker() {};
	
	
	//--------------------------------------------------------------------
	static void saveRecipe(Recipe r) throws FileNotFoundException, IOException, UnuniqueRecipeName {
		/*Сериализует рецепт и добавляет его в список всех рецептов (RecipeList)*/
		
		recipeList.addRecipe(r);
		saveRecipeList();
		ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(STORAGE+r.getName()+RECIPE_FORMAT));
		ous.writeObject(r);
		ous.close();
	}
	
	
	//--------------------------------------------------------------------
	static Recipe loadRecipe(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
		/*Десериализует рецепт с указанным именем*/
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STORAGE+name+RECIPE_FORMAT ));
		Recipe recipe = (Recipe)ois.readObject();
		ois.close();
		return recipe;
	}
	
	
	//--------------------------------------------------------------------
//	HashMap<Type, ArrayList<Recipe>> loadAllRecipes(){
//		return null;
//	}
	
	
	//--------------------------------------------------------------------
	static void saveRecipeList() throws FileNotFoundException, IOException {
		/*Сериализует список рецептов (RecipeList)*/
		
		ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(STORAGE+"recipeList"+RECIPE_LIST_FORMAT));
		ous.writeObject(recipeList);
		ous.close();
	}
	
	
	//--------------------------------------------------------------------
	private static RecipeList loadRecipeList() throws FileNotFoundException, IOException, ClassNotFoundException {
		/*Десериализует список рецептов */
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STORAGE+"recipeList"+RECIPE_LIST_FORMAT ));
		RecipeList recipeList = (RecipeList)ois.readObject();
		ois.close();
		return recipeList;
	}
	
	
//	--------------------------------------------------------------------
	static RecipeList getRecipeList() {
		return recipeList;
	}
}
