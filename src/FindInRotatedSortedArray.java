import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindInRotatedSortedArray {
	public int search(final List<Integer> a, int b) {
	    int low =0, high = a.size()-1, mid=0, found=-1, min=Integer.MAX_VALUE, mini=-1;
	    
	    while(low<=high){
	        mid=(low+high)/2;
	        if(a.get(mid)==b)
	            return mid;
	        if(a.get(low)>a.get(high)){
    	        if(a.get(high)<a.get(mid)){
    	            low=mid+1;
    	        }else if(a.get(low)>a.get(mid)){
    	            high=mid-1;
    	        }
    	       
	        }else{
	            if(a.get(mid)>b){
	                low=mid+1;
	            }else{
	                high=mid-1;
	            }
	        }
         if(min>a.get(mid)){
            min=a.get(mid);
            mini=mid;
	        }
	    }
	    low=0; high = a.size()-1; mid=mini;
	    if(a.get(high)>=b&&a.get(mini)<=b){
	        low=mini+1;
	    }else{
	        high=mini-1;
	    }
	    while(low<=high){
	        mid=(low+high)/2;
	        if(a.get(mid)==b)
	            return mid;
	        if(a.get(mid)>b)
	            high=mid-1;
	        else
	            low=mid+1;
	    }
	    
	    return found;
	}
 public static void main(String[] args){
		FindInRotatedSortedArray fin = new FindInRotatedSortedArray();
		ArrayList<Integer> al = new ArrayList<Integer>();
		int b;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while(n-->0){
			al.add(scan.nextInt());
		}
		System.out.println(al);
		b=scan.nextInt();
		fin.search(al, b);
	}
}
