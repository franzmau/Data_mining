import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser parser = new Parser();

		parser.readAttributes();

		try{
		parser.generateTree();
		}
		catch (Exception e){
			System.out.print("Error, It can't be solved");
		}
	}

}
