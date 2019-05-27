package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*��������� ������*/

public class Util {
	
	
	 //--------------------------------------------------------------------
	 static String getUserInputStr() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input="";
			try {
				input = reader.readLine();
				input.trim();
			} catch (IOException e) {
				println("��������� ������ �����!");
				e.printStackTrace();
				System.exit(1);
			}
			return input;
		}
		
		
		//--------------------------------------------------------------------
		static int getUserInputInt() {
			int result;
			try {
				//�������� ���� ������������ ������ "" 
				result = Integer.parseInt(getUserInputStr());
			}catch(NumberFormatException e) {
				//�� ���� ��������� ������������� ����� �� ���������
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
			/*����������� ���������������� ������. ��������� � 1. 0 - ������� � ���������� ���.*/
			
			StringBuilder sb =new StringBuilder();
			int number =1; 
				
			for(Object o : objects) {
				sb.append(" " + number + ". ");
				sb.append(o);
				sb.append("\n");
				number++;
			}
			sb.append(" 0. �����.");
			println(sb.toString());
		}	
		
		
		//--------------------------------------------------------------------
		static void printNumList( Object[] objects, String lastLine ) {
			/*����������� ���������������� ������. ��������� � 1.C ������������� ������� �������.*/
			
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
		public static boolean input�orrect( int input , int listLength ) {
			/*��������� ����� ������� �� ������� ����������� ������������ ������*/
			
			if( input < 0 || input > listLength ) {
				return false;
			}else {
				return true;
			}
		}
		
}
