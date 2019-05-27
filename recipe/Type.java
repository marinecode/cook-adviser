package recipe;

import java.io.Serializable;

/*Тип блюда. Первое, Второе, Горячее, Гарнир, Завтрак, Салат, Десерт, Напиток, Закуска, Выпечка*/	

public class Type implements Serializable {
	
	public static final Type FIRST = createNewType("Первое");
	public static final Type SECOND = createNewType("Второе");
	public static final Type HOT = createNewType("Горячее");
	public static final Type GARNISH = createNewType("Гарнир");
	public static final Type BREAKFAST = createNewType("Завтрак");
	public static final Type SALAD = createNewType("Салат");
	public static final Type DESSERT = createNewType("Десерт");
		
	private String typeName;
	
	private Type( String typeName ) {
		this.typeName = typeName;
	}
	
	
	//--------------------------------------------------------------------
	public static Type createNewType( String typeName ) {
		/* Создание пользовательских типов блюд*/
		
		return new Type( typeName );
	}
	
	
	//--------------------------------------------------------------------
	public String getTypeName() {
		return typeName;}
	
	
	//--------------------------------------------------------------------
	public String toString() {
		return typeName;}

	
	//--------------------------------------------------------------------
	public boolean equals( Object o ) {
		Type t = (Type)o;
		if(this.typeName.equals( t.getTypeName() ))
			return true;
		return false;
	}
	
	
	//--------------------------------------------------------------------
	public int hashCode() {
		return typeName.hashCode();
	}
}
