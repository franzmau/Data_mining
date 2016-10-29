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
	
	/*
	public void set_HashTable(Double Probab, String Previous){
		Conditional_Prob_Table.put(Previous, Probab);
		

	}
		
	
	public String toString(){
		String output="";
		output+= "Name= "+this.name+" Probability"+this.probability+" \n ";
				
				output += "\n HAsh table";
				for(String currentKey : this.Conditional_Prob_Table.keySet()){
					output+="[ "+currentKey+"] -> "+ this.Conditional_Prob_Table.get(currentKey)+" \n";
				}
		return output;		
	}
	
	
	public double get_probability(){
		return this.probability;
	}
	
	public void set_probability(double probability){
		this.probability=probability;
	}
	
	
	public double return_negative(double probability){
		return 1-probability;
	}
	
	
	
	public String get_name(){
		return this.name;
	}
	
	public void set_name(String name){
		 this.name=name;
	}
	
	public void printArrayList(ArrayList<String> array, String title){
		
	}
	
	public double getPositiveProbability(ArrayList<String> jointNodes){
		if(this.probability != -1){
			return this.probability;
		}
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> copy_keys = new ArrayList<String>();
		for(String currentKey : this.Conditional_Prob_Table.keySet()){
			for(int i = 0; i < jointNodes.size(); i++){
				if(currentKey.toLowerCase().contains(jointNodes.get(i).toLowerCase())){
					keys.add(currentKey);
					copy_keys.add(currentKey);
				}
			}
		}
		
		if(keys.size() == 1){
			return this.Conditional_Prob_Table.get(keys.get(0));
		}

		
		for(int i = 0; i < keys.size(); i++){
			printArrayList(copy_keys,"COPY KEYS BEFORE");
			copy_keys.remove(keys.get(i));
			printArrayList(copy_keys,"COPY KEYS AFTER");
			if(copy_keys.contains(keys.get(i))){
				return this.Conditional_Prob_Table.get(keys.get(i));
			}
			copy_keys = (ArrayList<String>) keys.clone();
		}
		return -1;
	}
	
	public double getNegativeProbability(ArrayList<String> jointNodes){
		if(this.probability != -1){
			return 1-this.probability;
		}
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> copy_keys = new ArrayList<String>();
		for(String currentKey : this.Conditional_Prob_Table.keySet()){
			for(int i = 0; i < jointNodes.size(); i++){
				if(currentKey.toLowerCase().contains(jointNodes.get(i).toLowerCase())){
					keys.add(currentKey);
					copy_keys.add(currentKey);
				}
			}
		}
		if(keys.size() == 1){
			return 1 - this.Conditional_Prob_Table.get(keys.get(0));
		}
		for(int i = 0; i < keys.size(); i++){
			copy_keys.remove(keys.get(i));
			if(copy_keys.contains(keys.get(i))){
				return (1-this.Conditional_Prob_Table.get(keys.get(i)));
			}
			copy_keys = (ArrayList<String>) keys.clone();
		}
		
		return -1;
	}
	
	*/
	
	
	
}