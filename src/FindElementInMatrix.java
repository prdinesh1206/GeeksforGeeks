import java.util.ArrayList;
import java.util.Scanner;

public class FindElementInMatrix {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    ArrayList<Integer> lastCol =new ArrayList<Integer>();
	    int maxCol = a.get(0).size();
	    int maxRow = a.size();
	    
	    if(a.get(0).get(0)>b)
	    	return 0;
	    if(a.get(maxRow-1).get(maxCol-1)<b)
	    	return 0;
	    for(int i=0;i<a.size();i++){
	        lastCol.add(a.get(i).get(maxCol-1));
	    }
	    int low = 0, high = maxRow-1, mid, found =-1;
	    
	    while(low<=high){
	        mid=(low+high)/2;
	        if(lastCol.get(mid)==b)
	            return 1;
	        if(lastCol.get(mid)<b){
	        	low=mid+1;
	        }else{
	        	found=mid;
	            high=mid-1;
	        }
	        
	    }
	    ArrayList<Integer> temp = a.get(found);
	    low=0;
	    high = maxCol-1;
	    
	    while(low<=high){
	    	mid=(low+high)/2;
	    	if(temp.get(mid)==b)
	    		return 1;
	        if(temp.get(mid)<b)
	        	low=mid+1;
	        else
	        	high=mid-1;
	    }
	    
	    return 0;
	}
	public static void main(String[] args){
		FindElementInMatrix fe = new FindElementInMatrix();
		Scanner scan = new Scanner(System.in);
		int m= scan.nextInt();
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<m;i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				temp.add(scan.nextInt());
			}
			a.add(temp);
		}
		System.out.println(fe.searchMatrix(a,15));
	}
}
