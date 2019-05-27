package recipe;

import java.io.Serializable;

/*��� �����. ������, ������, �������, ������, �������, �����, ������, �������, �������, �������*/	

public class Type implements Serializable {
	
	public static final Type FIRST = createNewType("������");
	public static final Type SECOND = createNewType("������");
	public static final Type HOT = createNewType("�������");
	public static final Type GARNISH = createNewType("������");
	public static final Type BREAKFAST = createNewType("�������");
	public static final Type SALAD = createNewType("�����");
	public static final Type DESSERT = createNewType("������");
		
	private String typeName;
	
	private Type( String typeName ) {
		this.typeName = typeName;
	}
	
	
	//--------------------------------------------------------------------
	public static Type createNewType( String typeName ) {
		/* �������� ���������������� ����� ����*/
		
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
