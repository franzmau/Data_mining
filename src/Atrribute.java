import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class Atrribute {
	
	
	public ArrayList <String> States; 
	public String name;
	

	public Atrribute(String name){
		this.name=name;
		 States=new ArrayList<String>(); 
		
	}
	
	public void addState(String state){
		this.States.add(state);
	}
	public ArrayList <String> getStates(){
		return States;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	
	
	
}