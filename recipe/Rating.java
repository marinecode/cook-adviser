package recipe;

import java.io.Serializable;

/*������� �������. ������� ������������ �� ������� ������������� ������� � ������� ������� �� �������������.*/

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
