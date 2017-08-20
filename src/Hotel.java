import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hotel {
	
	    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
	        ArrayList<Events> events=new ArrayList<Events>();
	    	int i, j;
	        for(i=0;i<arrive.size();i++){
	           events.add(new Events(true, arrive.get(i))); 
	        }
	        for(i=0;i<depart.size();i++){
	            events.add(new Events(false, depart.get(i)));
	        }
	       
	        Collections.sort(events);
	        for(j=0;j<events.size();j++){
	            System.out.println(events.get(j).day+" "+events.get(j).arrival);
	        }
	        
	        System.out.println();
	        int k=0;
	        
	        for(j=0;j<events.size();j++){
	        	if(events.get(j).arrival){
	        		k++;
	        	}else{
	        		k--;
	        	}
	        	if(k>K)
	        		return false;
	        }
	        
	        
	        return true;
	    }
	    
	    class Events implements Comparable<Events>{
	        boolean arrival;
	        int day;
	        public Events(boolean arrival, int day){
	            this.arrival = arrival;
	            this.day = day;
	        }
	        public int compareTo(Events e){
	        	int eday=((Events) e).day;
	        	boolean arrival=((Events) e).arrival;
	        	if(this.day==eday){
	        		if(arrival && this.arrival)
	        			return 0;
	        		else if(this.arrival)
	        			return 1;
	        		else 
	        			return -1;
	        	}else{
	        	return this.day-eday;
	        	}
	        }
	    }
	    public static void main(String[] args){
	    	Hotel hotel=new Hotel();
	    	
	    	ArrayList<Integer> arrive=new ArrayList<Integer>();
	    	ArrayList<Integer> depart=new ArrayList<Integer>();
	    	
	    	arrive.add(1);
	    	arrive.add(2);
	    	arrive.add(3);
	    	depart.add(2);
	    	depart.add(3);
	    	depart.add(4);
	    	boolean possible=hotel.hotel(arrive, depart, 1);
	    	System.out.println(possible);
	    	
	    }
}