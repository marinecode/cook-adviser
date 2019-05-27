package development;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import recipe.IngredientList;
import recipe.Recipe;
import recipe.Type;

public class Parser {
	String dishesFile = "C:\\Javast\\CookAdvicer\\Блюда.txt";
	
	private String[] readFile( String directory ) throws IOException {
		
		BufferedReader reader = new BufferedReader( new FileReader( directory ));
		ArrayList<String> result = new ArrayList<String>();
		String line ="";
		while( (line = reader.readLine()) != null ) {
			result.add( line );
		}
		reader.close();
		return result.toArray(new String[] {});
	}
	
		
	public Recipe[] makeRecipesFromFile() throws IOException {
		String name = null;
		String type = null;
		ArrayList<String> ingredients = null;
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		String[] lines = readFile( dishesFile );
		
		for(String line : lines) {
			String subLine = line.substring(1);
			String[] splitedLine = subLine.split("/");
			type = splitedLine[0];
			name = splitedLine[1];
			
			ingredients = new ArrayList<String>();
			ingredients.add(splitedLine[2]);
			String [] ing = ingredients.toArray(new String[] {});
			
			Recipe r = new Recipe(name, Type.createNewType(type), new IngredientList(ing[0]) );
			
			recipes.add(r);
		}
		return recipes.toArray(new Recipe[] {});
	}
}
