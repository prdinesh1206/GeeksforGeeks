import java.util.*;
public class MaxConsGap {

	// DO NOT MODIFY THE LIST
	public int maximumGap(final List<Integer> a) {
	    if(a.size()<2)
	        return 0;
	    int max=0, i=0;
	    int[] ar=new int[a.size()];
	    for(int num: a){
	        ar[i++]=num;
	        if(num>max)
	            max=num;
	    }
	    for(i=1; max/i>0; i=i*10){
	        countSort(ar, i);
	    }
	    for(i=0;i<a.size();i++)
	        System.out.print(ar[i]+" ");
	   
	    System.out.println();
	    return 0;
	}
	public void countSort(int[] ar, int digitIndex){
	    int n=ar.length;
	    int[] output=new int[n];
	    int[] count=new int[10];
	    for(int i=0;i<n;i++){
	        count[(ar[i]/digitIndex)%10]++;
	    }
	    for(int i=1;i<10;i++){
	        count[i]+=count[i-1];
	    }
	    for(int i=0;i<n;i++){
	        output[count[(ar[i]/digitIndex)%10]-1] = ar[i];
	        count[(ar[i]/digitIndex)%10]--;
	    }
	    for(int i=0;i<n;i++)
	        ar[i] = output[i];
	    
	}
	public static void main(String[] args){
		MaxConsGap maxg=new MaxConsGap();
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(10);
		al.add(2);
		al.add(4);
		al.add(8);
		al.add(3);
		maxg.maximumGap(al);
	}

}
