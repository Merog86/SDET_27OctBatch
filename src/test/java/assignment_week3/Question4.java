package assignment_week3;

import java.util.Iterator;
// Assignment week 3- assignment Question4
public class Question4 {
	public static void main(String[] args) {
	SetAndList sl=new SetAndList();
	int listSize=SetAndList.listAsReturnType().size();
	//Printing List values
	System.out.println("List values:");
	for(int i=0; i<listSize;i++)
	{
		System.out.println(SetAndList.listAsReturnType().get(i));
	}
	
	System.out.println("Set values:");
	Iterator<String> itr=SetAndList.setAsReturnType().iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
		
	}
}
