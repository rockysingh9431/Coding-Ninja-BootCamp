package src.FamilyClass;
import java.util.* ;
import java.io.*; 

// Create the classes here
class GrandFather{
	String grandFatherName;
	GrandFather(String grandFatherName){
		System.out.println("g");
		this.grandFatherName=grandFatherName;
	}
}

class Father extends GrandFather{
	String fatherName;
	Father(String fatherName,String grandFatherName){
		super(grandFatherName);
		System.out.println("p");
		this.fatherName=fatherName;
	}
}
class Son extends Father{
	String sonName;
	Son(String sonName, String fatherName,String grandFatherName){
		super(fatherName,grandFatherName);
		System.out.println("s");
		this.sonName=sonName;
	}
	public void printName(){
		System.out.println("sonname:  "+sonName+"\n"+ "fathername:  "+fatherName+"\n"+ "grandfather:  "+grandFatherName);
	}
}
class Solution {
	
	public static void main(String args[]) {
		
		// Write your code here
		Son s=new Son("Saurabh","Ramesh","Suresh");
		s.printName();
	}
}
