import java.util.ArrayList;


public class operations_with_int_array_BH {
	
	public Integer max (ArrayList<Integer> input){
		
		Integer i,max_value_in_the_int_array=input.get(0);
		
		for(i=1; i<input.size(); i++){
			if (input.get(i)>max_value_in_the_int_array) {
				max_value_in_the_int_array=input.get(i);
			}
		}
		
		return max_value_in_the_int_array;
	}
	
	
	
	
	public Integer min (ArrayList<Integer> input){
		
		Integer i,min_value_in_the_int_array=input.get(0);
		
		for(i=1; i<input.size(); i++){
			if (input.get(i)<min_value_in_the_int_array) {
				min_value_in_the_int_array=input.get(i);
			}
		}
		
		return min_value_in_the_int_array;
	}

	
	

}
