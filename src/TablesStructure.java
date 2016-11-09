import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class TablesStructure {
	private ArrayList <Data> PureTable;
	private ArrayList <Atrribute> Divider;
	
	public TablesStructure() {
		PureTable = new ArrayList <Data>();
		Divider = new ArrayList <Atrribute>();
	}
	
	public TablesStructure(ArrayList <Data> PureTable, ArrayList <Atrribute> Divider){
		this.PureTable = PureTable;
		this.Divider = Divider;
	}
	
	public TablesStructure(ArrayList <Atrribute> Divider){
		PureTable = new  ArrayList <Data>();
		this.Divider = Divider;
	}
	
}