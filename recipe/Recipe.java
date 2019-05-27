package recipe;

import java.io.Serializable;
import java.util.Arrays;

/*Класс представляющий рецепт. Название блюда, его тип, рейтинг, список ингридиентов*/

public class Recipe implements Serializable {
	private String name;
	private Type type;
	private Rating r;
	public IngredientList list;
		
	public Recipe( String name, Type type, IngredientList list ) {
		
		this.name = name;
		this.type = type;
		this.list = list;
		r = new Rating();
	}
	
	
	//--------------------------------------------------------------------
	public int getRatingValue() {
		return r.getRating();
	}
	
	
	//--------------------------------------------------------------------
	public String getName() {
		return name;
	}
	
	
	//--------------------------------------------------------------------
	public Type getType() {
		return type;
	}
	
	
	//--------------------------------------------------------------------
	public void setIngredientList( String... ingredients ) {
		list.clear();
		list.addAll(Arrays.asList( ingredients ));
	}
	
}
