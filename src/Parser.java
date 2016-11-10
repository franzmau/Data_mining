import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Parser {
	public static InputReader in;
	private ArrayList<Data> datas;
	public ArrayList<Atrribute> attributes;

	
	public Parser(){
		in = new InputReader(System.in);
	}
	
	public void readAttributes(){
		attributes = new ArrayList<Atrribute>();
		datas=new ArrayList<Data>();
		String relationText;
		
			do{ 
				relationText = in.readLine();
			
			}while(!relationText.contains("@relation"));
			
		  relationText=in.readLine();
		  String attributesText;
		 
		  attributesText=in.readLine();  
			  while(attributesText.contains("@attribute")){ 
		 		  	String[] splitedText = attributesText.split("\\s+");
		 		  	Atrribute attribute =new Atrribute(splitedText[1]);
		 		  	//The first one says attribute and the second one says the name of the attribute
		 		    for(int i=2;i<splitedText.length;i++){
					  splitedText[i] = splitedText[i].replace("$", "").replace(",", "").replace("{", "").replace("}", "");
					  attribute.addState(splitedText[i]);
			   	   	//all the names are added to the arraylist
		 		  	}
		 		  	attributes.add(attribute);
		 		  	attributesText=in.readLine();
			  		}
				   /*
				   for(Atrribute a:attributes){
					   System.out.println("Nombre "+a.getName());
					   ArrayList <String> S=a.getStates();
					   for(String s:S){
						   System.out.println("Estado "+s);
					   }
					   System.out.println("");
				   }*/
			do{ 
			  relationText = in.readLine();
			  }while(relationText.contains("@data") || relationText.contains("%"));
			
			int count=0;
			String data=relationText;
			do{
				 String[] spliteddata = data.split(",");
	 		  	 Data new_data =new Data(count);
	 		  	  for (String s:spliteddata){
	 		  		 new_data.addAttributes(s);
	 		  	    }
	 		  	 datas.add(new_data);
	 		  	 count ++;
	 		     }while(!(data = in.readLine()).equals(""));
			/*
			for(Data a:datas){
				   
				   ArrayList <String> S=a.getAttibutes();
				   System.out.print("id "+a.getId());
				   for(String s:S){
					   System.out.println(" Estado "+s);
				   }
				   System.out.println("");
			   }
			*/

	}
	
	public int compute(TablesStructure table_to_calculate){
		double entropy;
		//do{
		entropy=calculate_entropy(table_to_calculate);
		if(entropy == 0){
			return -1;
		}
		//System.out.print("entropy ="+entropy);
		int  best_option=best_gain(entropy, table_to_calculate);
		//}while(entropy>0);
		return best_option;
	}
	
	public int best_gain(double entropy, TablesStructure table_to_calculate){
		double gain = 0;
		int best=-1;
		for (int i=0;i<attributes.size()-1;i++){
			double	aux= calculate_gain(entropy,i, table_to_calculate);
			if(aux>gain){
				best=i;
				gain = aux;
			}
		}
		return best;
	}
	
	public void generateTree(){
		TablesStructure t = new TablesStructure(this.datas);
		Queue<String> q = new LinkedList<String>(); 
		this.do_decisionTree(t, 0, "", q);
	}
	
	public double calculate_gain(double entropy, int i, TablesStructure table_to_calculate){
		double gain=0;
		ArrayList<Data> data_tree = table_to_calculate.getArrayList();
		double j=data_tree.size();
		double counter=0;
		for(String s: attributes.get(i).getStates()){
			ArrayList <Integer>p = new  ArrayList<Integer>();
			ArrayList <String> l=new ArrayList<String>();
			for(Data d:data_tree){		
				
				
				if(d.getAttribute(i).equals(s)){
					if(!l.contains(d.getLastAttribute())){
						l.add(d.getLastAttribute());
						p.add(1);
					}else{
						int index= l.indexOf(d.getLastAttribute());
						int var=p.get(index)+1;
				       p.remove(index);
				      p.add(index,var );
						}
					counter++;
				}
			}
			for(Integer in:p){
				gain+=(((in/counter)*Math.log10(in/counter) / Math.log10(2.0)*-1))*(counter/j)*-1 ;
				}
			counter=0;
			p = new  ArrayList<Integer>();				
		}
		gain=entropy+gain;
		return gain;
	}
	
	public double calculate_entropy(TablesStructure table_to_calculate){
		double frequency = 0;
		ArrayList<Data> data_tree = table_to_calculate.getArrayList();
		double acum = data_tree.size();
		double i=0;
		
			for (String s :this.attributes.get(attributes.size()-1).getStates()){
				for (Data d: data_tree){
					if(d.getLastAttribute().equals(s)){
						i++;
					}
				}
				if(i!=0){
				frequency+=((i/acum)*Math.log10(i/acum) / Math.log10(2.0)*-1);
				}
				i=0;
			}
		
		return frequency;
	}
	
	public String first = "";
	
	public void do_decisionTree(TablesStructure decision_table, int index, String value, Queue<String> tabs) {
		int divider_index = compute(decision_table);
		if(divider_index == -1){ //Pure table obtained
			for(int j = 0; j < tabs.size(); j++){
				System.out.print("  ");
			}
			
			tabs.poll();
			System.out.println("ANSWER: " + decision_table.getArrayList().get(0).getLastAttribute());
		} else {
			ArrayList<String> values = decision_table.getAttributes(divider_index,attributes.get(divider_index).getStates());
			
			for(int i = 0; i < values.size(); i++){
				Atrribute cur_attribute = attributes.get(divider_index);
				
				if(cur_attribute.getName().equals(first)){
					while(!tabs.isEmpty()){
						tabs.poll();
					}
				}
				for(int j = 0; j < tabs.size(); j++){
					System.out.print("  ");
				}
				System.out.println(cur_attribute.getName() + ": " + values.get(i));
				if(first.isEmpty()){
					first = cur_attribute.getName();
				}
				tabs.add("  ");
				TablesStructure decision_subTable = decision_table.getSubtable(divider_index, values.get(i));
				do_decisionTree(decision_subTable, divider_index, values.get(i), tabs);
				
			}
		}
		
	}
}