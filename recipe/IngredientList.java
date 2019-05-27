package recipe;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;

public class IngredientList extends HashSet<String> implements Serializable {
	
	public IngredientList( String...ingredients ) {
		super(Arrays.asList( ingredients ));		
	}
	
	
	//--------------------------------------------------------------------
	public IngredientList createIngredientList( String...ingredients ) {
		return new IngredientList( ingredients );
	}

}
