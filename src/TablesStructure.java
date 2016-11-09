import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class TablesStructure {
	private ArrayList<Data> table;
	
	public TablesStructure(){
		this.table = new ArrayList<Data>();
	}
	
	private TablesStructure(ArrayList<Data> table){
		this.table = new ArrayList<Data>();
		for(int i = 0; i < table.size(); i++){
			Data data = new Data(table.get(i));
			this.table.add(data);
		}
	}
	
	public ArrayList<String> getAttributes(int index){
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0; i < this.table.size(); i++){
			String actualString = this.table.get(i).getAttribute(index);
			if(!output.contains(actualString)){
				output.add(actualString);
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
			if(actualString.contains(value)){
				trimmedData.add(this.table.get(i));
			}
		}
		return new TablesStructure(trimmedData);
	}
	
}