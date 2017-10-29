import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Google {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
//		Arrays.sort(input);
//		for(String s: input){
//			System.out.print(s+" ");
//		}
		int l = input.length;
		ArrayList<String> al = new ArrayList<String>();
		for(String s : input){
			al.add(s);
		}
//		Collections.sort(al);
		Collections.sort(al, new NumComparator());
		for(int i=al.size()-1;i>=0;i--){
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
	}
	
	public boolean findTriplets(int arr[] , int n)
       {
         //add code here.
        for(int i=n-1;i>=0;i--){
            if(findSum(arr, -arr[i], i)){
                return true;
            }
        }
        return false;
       }
      
    public boolean findSum(int[] arr, int sum, int l){
       int curr = sum;
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       for(int i=0;i<l;i++){
           if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);   
           }else{
                map.put(arr[i], 1);
           }
       }
       for(int i=l-1;i>=0;i--){
           map.put(arr[i], map.get(arr[i])-1);
           if (map.containsKey(sum-arr[i]) && map.get(sum-arr[i]) > 0){
               return true;
           }
           map.put(arr[i], map.get(arr[i])+1);
       }
       return false;
   }
}
class NumComparator implements Comparator<String>{
    public int compare(String num1, String num2){
        int l1 = num1.length(), l2 = num2.length();
        if(l1 == l2){
            return num1.compareTo(num2);
        }
        int i=0, j=0;
        while(i<l1 && j<l2){
            if(num1.charAt(i)<num2.charAt(j)){
                return -1;
            }else if(num1.charAt(i)>num2.charAt(j)){
                return 1;
            }
            i++;
            j++;
        }
        if(i!=l1){
        	j=0;
	        while(j< l2){
	        	
	            if(num1.charAt(i)<num2.charAt(j)){
	                return -1;
	            }else if(num1.charAt(i)>num2.charAt(j)){
	                return 1;
	            }else{
	            	j++;
	            }
	        }
        }
        else if(j!=l2){
	    	i=0;
	        while(i<l1){
	            if(num1.charAt(i)>num2.charAt(j)){
	                return 1;
	            }else if(num1.charAt(i)<num2.charAt(j)){
	                return -1;
	            }else{
	            	i++;
	            }
	        }
        }
        return 0;
    }
}
