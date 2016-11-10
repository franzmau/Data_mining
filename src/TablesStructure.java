import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class TablesStructure {
	private ArrayList<Data> table;
	
	public TablesStructure(){
		this.table = new ArrayList<Data>();
	}
	
	public TablesStructure(ArrayList<Data> table){
		this.table = new ArrayList<Data>();
		for(int i = 0; i < table.size(); i++){
			Data data = new Data(table.get(i));
			this.table.add(data);
		}
	}
	
	public ArrayList<String> getAttributes(int index, ArrayList<String> OldValues){
		ArrayList<String> output = new ArrayList<String>();		
		 int counter []=new int [OldValues.size()];
		for(int i = 0; i < OldValues.size(); i++){
			output.add(OldValues.get(i));
			counter[i]=0;
		}
		for(int i = 0; i < this.table.size(); i++){
			String actualString = this.table.get(i).getAttribute(index);
				int old_index = OldValues.indexOf(actualString);
				if(old_index != -1){
					counter[old_index]+=1;
				}
		}
		for(int i=0; i < OldValues.size(); i++){
			if(counter[i] == 0){
				output.remove(output.indexOf(OldValues.get(i)));
			}
			
		}
		return output;
	}
	
	public ArrayList<Data> getArrayList(){
		return this.table;
	}
	
	public TablesStructure getSubtable(int index, String value){
		ArrayList<Data> trimmedData = new ArrayList<Data>();
		for(int i = 0; i < this.table.size(); i++){
			String actualString = this.table.get(i).getAttribute(index);
			if(actualString.equals(value)){
				trimmedData.add(this.table.get(i));
			}
		}
		return new TablesStructure(trimmedData);
	}
	
}