package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Служебные методы*/

public class Util {
	
	
	 //--------------------------------------------------------------------
	 static String getUserInputStr() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input="";
			try {
				input = reader.readLine();
				input.trim();
			} catch (IOException e) {
				println("Произошла ошибка ввода!");
				e.printStackTrace();
				System.exit(1);
			}
			return input;
		}
		
		
		//--------------------------------------------------------------------
		static int getUserInputInt() {
			int result;
			try {
				//Вылетает если пользователь вводит "" 
				result = Integer.parseInt(getUserInputStr());
			}catch(NumberFormatException e) {
				//Во всей программе отрицательные числа не допустимы
				result = -1;
			}
			return result;
		}
		
		
		//--------------------------------------------------------------------
		static void println( Object o ) {
				System.out.println( o );
			}
			
			
		//--------------------------------------------------------------------
		static void printNumList( Object[] objects ) {
			/*Отображение пронумерованного списка. Нумерация с 1. 0 - возврат в предыдущий шаг.*/
			
			StringBuilder sb =new StringBuilder();
			int number =1; 
				
			for(Object o : objects) {
				sb.append(" " + number + ". ");
				sb.append(o);
				sb.append("\n");
				number++;
			}
			sb.append(" 0. Назад.");
			println(sb.toString());
		}	
		
		
		//--------------------------------------------------------------------
		static void printNumList( Object[] objects, String lastLine ) {
			/*Отображение пронумерованного списка. Нумерация с 1.C настраиваемой нулевой строкой.*/
			
			StringBuilder sb =new StringBuilder();
			int number =1; 
				
			for(Object o : objects) {
				sb.append(" " + number + ". ");
				sb.append(o);
				sb.append("\n");
				number++;
			}
			sb.append(" 0. " + lastLine + ".");
			println(sb.toString());
		}	
		
		
		//--------------------------------------------------------------------
		public static boolean inputСorrect( int input , int listLength ) {
			/*Введенное число выходит за границы показанного пользователю списка*/
			
			if( input < 0 || input > listLength ) {
				return false;
			}else {
				return true;
			}
		}
		
}
