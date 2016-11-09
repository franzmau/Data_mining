import java.util.ArrayList;


public class Data {
	
	public ArrayList <String> Attributes;
	public int id;
	
	public Data(int id){
		this.id=id;
		Attributes= new ArrayList<String>();
	}
	
	public Data(Data data){
		this.id = data.id;
		Attributes= new ArrayList<String>();
		for(int i = 0; i < data.getAttibutes().size(); i++){
			this.Attributes.add(data.getAttibutes().get(i));
		}
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
	public String getAttribute(int index){
		return this.Attributes.get(index);
	}
	
}
