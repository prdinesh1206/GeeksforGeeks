import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMedianInTwoSortedArrays {
	public static void main(String[] args){
		FindMedianInTwoSortedArrays fin = new FindMedianInTwoSortedArrays();
		Scanner scan = new Scanner(System.in);
		int m, n;
		m=scan.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		while(m-->0){
			a.add(scan.nextInt());
		}
		n=scan.nextInt();
		while(n-->0){
			b.add(scan.nextInt());
		}
		System.out.println(fin.findMedianSortedArrays(a, b));
	}
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    int m = a.size(), n = b.size(), sum=m+n;
	    int value1=0, value2=0;
	    if(m>n){
	        value1=solve(b, a, 0, 0, n, m, (sum/2)+1);
	        if(sum%2==0){
	            value2=solve(b,a,0,0,n,m, (sum/2));
	        }else{
	            value2=value1;
	        }
	        System.out.println(value1+" "+value2);
	        return (value1+value2)/2.0;
	    }else{
	        value1=solve(a,b,0,0,m,n, (sum/2)+1);
	        if(sum%2==0){
	            value2=solve(a,b,0,0,m,n,(sum/2));
	        }else{
	            value2=value1;
	        }
	        System.out.println(value1+" "+value2);
	        return (value1+value2)/2.0;
	    }
	}
	public int solve(List<Integer> a, List<Integer> b, int start1, int start2, int m, int n, int k){
        System.out.println(start1+" "+start2+" "+m+" "+n+" "+k);
        if(m==0){
            return b.get(k-1);
        }
        if(k==1){
        	System.out.println(a.get(start1));
        	System.out.println(b.get(start2));
            return a.get(start1)>b.get(start2)?b.get(start2):a.get(start1);
        }
        int mid1=Math.min(k/2,m);
        int mid2=Math.min(k/2,n);
        
        if(a.get(start1+mid1-1)>b.get(start2+mid2-1)){
            return solve(a,b,start1,start2+mid2,m,n-mid2, k-mid2);
        }else{
            return solve(a,b,start1+mid1,start2,m-mid1,n, k-mid1);
        }
    }
}
