import java.util.ArrayList;


public class Data {
	
	public ArrayList <String> Attributes;
	public int id;
	
	public Data(int id){
		this.id=id;
		Attributes= new ArrayList<String>();
	}
	public void addAttributes(String s){
		Attributes.add(s);
	}
	
	public int getId(){
		return id;
	}
	public ArrayList<String> getAttibutes(){
		
		return this.Attributes;
	}
	public String getLastAttribute(){
		return this.Attributes.get(Attributes.size()-1);
	}
	
	
}
