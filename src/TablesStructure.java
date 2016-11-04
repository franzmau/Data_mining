import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Stack;

public class TablesStructure {
	private ArrayList <Data> PureTable;
	private ArrayList <Attribute> Divider;
	
	public TablesStructure() {
		PureTable = new ArrayList <Data>();
		Divider = new ArrayList <Attribute>();
	}
	
	public TablesStructure(ArrayList <Data> PureTable, ArrayList <Attribute> Divider){
		this.PureTable = PureTable;
		this.Divider = Divider;
	}
	
	public TablesStructure(ArrayList <Attribute> Divider){
		PureTable = ArrayList <Data>();
		this.Divider = Divider;
	}
	
}