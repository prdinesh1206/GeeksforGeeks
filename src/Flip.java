import java.util.ArrayList;

public class Flip {

    public static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> input=new ArrayList<Integer>();
        for(int i=0;i<A.length();i++){
            input.add(A.charAt(i)-'0');
        }
        for(int i=0;i<A.length();i++){
            if(input.get(i)==1){
                input.set(i,-1);
                
            }else{
                input.set(i,1);
            }
            System.out.print(input.get(i));
        }
        System.out.println();
        
        return maxSubArray(input);
    }
    public static ArrayList<Integer> maxSubArray(ArrayList<Integer> a){
        int start=0, end=0, s=0;
        int cur_max=0, max=Integer.MIN_VALUE;
        
        for(int i=0;i<a.size();i++){
            cur_max+=a.get(i);
            if(max<cur_max){
            	max=cur_max;
                start=s;
                end=i;
            }
            if(cur_max<0){
                cur_max=0;
                s=i+1;
            }
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        System.out.println(max);
       
        if(max>=0){
             result.add(start+1);
             result.add(end+1);
        }
        return result;
    }
    
    public static void main(String[] args){
    	ArrayList<Integer> x =flip("100101101");
    	System.out.println(x.get(0)+" "+x.get(1));
    	
    }

}
