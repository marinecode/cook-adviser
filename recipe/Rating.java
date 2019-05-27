package recipe;

import java.io.Serializable;

/*Рейтинг рецепта. Рейтинг основывается на частоте приготовления рецепта и частоте отказов от приготовления.*/

public class Rating implements Serializable{
	
	int rating = 0;
	
	
	//--------------------------------------------------------------------
	void renewRating() {
		//TODO
	};
	
	
	//--------------------------------------------------------------------
	int getRating() {
		return rating;}
	
	
	//--------------------------------------------------------------------
	public String toString() {
		return ""+rating;}
}
