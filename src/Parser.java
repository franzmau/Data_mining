import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

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
	
	public void compute(){
		double entropy;
		//do{
			entropy=calculate_entropy();
		//System.out.print("entropy ="+entropy);
		int  best_option=best_gain(entropy);
		//}while(entropy>0);
	}
	
	public int best_gain(double entropy){
		double gain=entropy;
		int best=-1;
		for (int i=0;i<attributes.size()-1;i++){
		double	aux= calculate_gain(entropy,i);
		if(aux>gain){
			best=i;
		}
		}
		return best;
	}
	
	public double calculate_gain(double entropy, int i){
		double gain=0;
		
		double counter=0;
		for(String s: attributes.get(i).getStates()){
			ArrayList <Integer>p = new  ArrayList<Integer>();
			ArrayList <String> l=new ArrayList<String>();
			for(Data d:datas){		
				
				
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
				System.out.print(in+" division ");
			}
			
			System.out.print("\n");
			System.out.print(" hay "+counter+" en "+s);
			System.out.print("\n");
			counter=0;
			p = new  ArrayList<Integer>();
			
			
			
			//System.out.println(counter+"counter y j"+j);
			//gain+=((counter/j)*Math.log10(counter/j) / Math.log10(2.0)*-1);		
		}
		
		System.out.println("\n");
		//System.out.println("counter "+counter);
		//System.out.println("el gain de "+i+" es "+gain);
		return gain;
	}
	
	public double calculate_entropy(){
		double frequency=0;
		double acum=datas.size();
		double i=0;
		
			for (String s :this.attributes.get(attributes.size()-1).getStates()){
				for (Data d: this.datas){
					if(d.getLastAttribute().equals(s)){
						i++;
					}
				}
				frequency+=((i/acum)*Math.log10(i/acum) / Math.log10(2.0)*-1);
				
				i=0;
			}
		
		return frequency;
	}
}