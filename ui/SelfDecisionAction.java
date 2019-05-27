package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import recipe.Recipe;
import recipe.Type;

	/*Интерфес для самостоятельного выбора рецепта из списка*/

public class SelfDecisionAction implements Action{

	
	//--------------------------------------------------------------------
	public boolean start() {
		/*Действия если хозяйка хочет выбрать сама из списка рецептов*/
			
		Util.println("Что будем готовить?");
		Recipe recipe;
		
		/*Хозяйка выбирает тип блюда и рецепт из появившихся пронумерованных списков.
		 * когда возвращается null это значит что пользователь решил вернуться
		 * на предыдущий шаг.*/
		do {
		Type type = selectType();
			if( type == null ) {
				return false;
			}
		recipe = selectRecipe( type );
		}while( recipe == null );
		
		// TODO Прописать обновление летописи. У этого рецепта надо обновить дату приготовления и изменить рейтинг
		return true;
	}	
	
		
	//--------------------------------------------------------------------
	private Type selectType() {
		/*Хозяйка выбирает тип блюда, которое собираемся готовить,
		 *из списка типов, рецепты которых уже в базе.*/
			
		Type[] types = UIHelper.getUsedTypes();
		int input;
		do {
			Util.printNumList(types);
			input =Util.getUserInputInt();
		}while( !Util.inputСorrect( input, types.length ) );
		
		Type selectedType = null;
		
		// При вводе 0, программа возвращается на предыдущий шаг.
		//В данном случае к стартовому экрану (выбор действия) 
		if(input == 0) {
			return selectedType;
		}
		
		selectedType = types[ input-1 ];
		return selectedType;
	}
	
	
	//--------------------------------------------------------------------
	private Recipe selectRecipe( Type type ) {
		/*Хозяйка выбирает блюдо из списка блюд одного типа*/
		
		String[] recipesNames = UIHelper.getRecipeList( type );
		int input = 0;
		
		//Добиваемся корректного ввода. Корректный диапазон recipesNames.length >= input >=0
		do {
			Util.printNumList( recipesNames );
			input = Util.getUserInputInt(); //  recipesNames.length >= input >=0		
		}while(!Util.inputСorrect( input, recipesNames.length ));
		
		Recipe selectedRecipe = null;
		// При вводе 0, программа возвращается на предыдущий шаг. В данном случае на выбор типа блюда 
		if( input == 0 ) {
			return selectedRecipe;
		}
		
		//Достаем выбранный рецепт по имени из базы данных
		String nameOfSelectedRecipe="";
		try {
			nameOfSelectedRecipe = recipesNames[ input-1 ];
			selectedRecipe = UIHelper.getRecipe( nameOfSelectedRecipe );
			
		}catch (FileNotFoundException e) {
			//Попробуем выбрать другой рецепт
			
			Util.println( "Файл " + nameOfSelectedRecipe  + ".rcp не найден( Попробуем что то другое?\n" );
			selectedRecipe = selectRecipe( type );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedRecipe;
	}
			
}
