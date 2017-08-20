import java.util.*;
public class MaximumAbsDiff {
    public static int maxArr(ArrayList<Integer> A) {
        int size=A.size();
        int start, end, current, max=Integer.MIN_VALUE;
        System.out.println("started");
        while(size>=0){
            start=0;
            end=size-1;
            
            while(end<A.size()&&(end>=start)&&(end+1-start==size)){
                
                current=Math.abs(A.get(end)-A.get(start))+Math.abs(end-start);
                //System.out.println(start+" "+end+": "+current);
                if(current>max){
                    max=current;
                }
             end=end+1;
             start=start+1;
            }
            size=size-1;
        }
    
        return max;
    }
    public static int maxArrOptimized(ArrayList<Integer> A){

        int[] first=new int[A.size()];
        int[] second=new int[A.size()];
        int f,s;
        int max1=Integer.MIN_VALUE, min1=Integer.MAX_VALUE, max2=Integer.MIN_VALUE;
        int min2=Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++){
            f=A.get(i)+i;
            if(f>max1)
                max1=f;
            if(f<min1)
                min1=f;
            s=A.get(i)-i;
            if(s>max2)
                max2=s;
            if(s<min2)
                min2=s;
        }
        BitSet bs=new BitSet();
        
      return Math.max((max2-min2), (max1-min1));  
    
    }
    public static void main(String[] args){
    	ArrayList<Integer> a =new ArrayList<Integer>();
    	a.add(1);
    	a.add(3);
    	a.add(-1);
    	maxArr(a);
    }
}
