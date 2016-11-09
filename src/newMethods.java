	public int compute(TablesStructure table_to_calculate){
		double entropy;
		//do{
		entropy=calculate_entropy(table_to_calculate);
		if(entropy == 0){
			return -1;
		}
		//System.out.print("entropy ="+entropy);
		int  best_option=best_gain(entropy);
		//}while(entropy>0);
		)
		return best_option;
	}
	
	public int best_gain(double entropy){
		double gain = 0;
		int best=-1;
		for (int i=0;i<attributes.size()-1;i++){
			double	aux= calculate_gain(entropy,i);
			if(aux>gain){
				best=i;
			}
		}
		return best;
	}
	
	public double calculate_gain(double entropy, int i, TablesStructure table_to_calculate){
		double gain=0;
		ArrayList<Data> data_tree = table_to_calculate.get_arraylist();
		double j=data_tree.size();
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
				gain+=(((in/counter)*Math.log10(in/counter) / Math.log10(2.0)*-1))*(counter/j)*-1 ;
				}
			counter=0;
			p = new  ArrayList<Integer>();				
		}
		gain=entropy+gain;
		System.out.print(" hay "+gain+" total de "+entropy);
		System.out.println("\n");
		return gain;
	}
	
	public double calculate_entropy(TablesStructure table_to_calculate){
		double frequency = 0;
		ArrayList<Data> data_tree = table_to_calculate.get_arraylist();
		double acum = data_tree.size();
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
	
	public void do_decisionTree(TablesStructure decision_table, int index, String value, Queue<String> tabs) {
		int divider_index = compute(decision_table);
		
		if(divider_index == -1){ //Pure table obtained
			Attribute cur_attribute = attributes.get(index);
			tabs.enqueue('1');
			while(tabs.dequeue() != '1'){
				System.out.print("\t");
			}
			System.out.println("ANSWER: " + value);
		} else {
			ArrayList<String> values = decision_table.getAttributes(divider_index);
			for(int i = 0; i < values.size(); i++){
				Attribute cur_attribute = attributes.get(divider_index);
				for(i = 0; i < tabs.size(); i++){
					System.out.print("\t");
				}
				System.out.println(cur_attribute.getName() + ": " + values.get(i));
				tabs.enqueue("\t");
				TablesStructure decision_subTable = decision_table.getSubtable(divider_index, values.get(i));
				do_decisionTree(decision_subTable, divider_index, values.get(i), tabs);
				
			}
		}
		
	}