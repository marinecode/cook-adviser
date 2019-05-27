package recipe;

import java.io.IOException;
import java.util.HashMap;

import development.Parser;



public class Test {

	public static void main(String[] args) throws IOException {
		Parser p = new Parser();
		Recipe[] recipes = p.makeRecipesFromFile();
		
		for(Recipe r : recipes) {
			printRecipe(r);
		}
	}
	
	static void printRecipe(Recipe r) {
		StringBuilder sb = new StringBuilder(r.getName());
		sb.append(" рхо " + r.getType());
		sb.append(" INGS " + r.list);
		System.out.println(sb.toString());
	}
}
