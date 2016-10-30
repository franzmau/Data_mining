import java.util.ArrayList;


public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser parser = new Parser();
				
		parser.readAttributes();
		
		parser.compute();
		/*ArrayList<String> a= new ArrayList<String>();
		a.add("hola");
		a.add("jajaja");
		a.add("paquito");
		
		a.add("dadadada");
		a.remove(1);
		
		for(int i=0;i<a.size();i++){
			System.out.println("estoy en el "+ i +"y tengo "+a.get(i));
			
		}
		*/
		//parser.readQuerys();		
	}

}
