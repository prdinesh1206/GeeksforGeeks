import java.util.*;

public class NumbersOfLength {

    public int solve(ArrayList<Integer> A, int B, int C) {
        boolean hasZero=false;
        String c=""+C;
        int result=0;
        int cLen = c.length();
        int aLen = A.size();
        boolean[] ar = new boolean[10];
        int[] br = new int[10];
        if(A.contains(0))
           hasZero=true;
        
        
        if(B>cLen)
           return 0;
         
        if(B<cLen){
            result=1;
            int b=aLen;
               for(int i=0;i<B;i++){
                   if(hasZero&&i == 0&&B!=1){
                       result*=(b-1);
                   }else{
                       result*=b;
                   }                
               }
           return result;
        }
        
        for(int i=0;i<aLen;i++){
            
           ar[A.get(i)]=true;
           //System.out.print(A.get(i)+" "+ar[A.get(i)]);
        }
       // System.out.println();
         //System.out.print(br[0]+" ");
        for(int i=1;i<10;i++){
            if(ar[i-1])
               br[i]=br[i-1]+1;
            else
               br[i]=br[i-1];
          // System.out.print(br[i]+" ");
        }
        //System.out.println();
       int sum=0;
       boolean foundIt=false, foundAn=false;
       int foundIndex=0;
       for(int i=0;i<cLen;i++){
           if(!ar[Character.getNumericValue(c.charAt(i))]){
               if(i!=0){
                   foundIndex=i;
                   foundIt=true;
                   break;
               }
           }else if(i==cLen-1){
           	   foundIt=true;
           	   foundIndex=i;
              }
       }
       System.out.println(foundIt+" "+foundIndex+" "+aLen);
       int sum1=0;
       if(foundIt){
           for(int j=0;j<=foundIndex;j++){
               if(j==0&&hasZero)
                   sum1=br[Character.getNumericValue(c.charAt(j))]-1;
               else
                   sum1=br[Character.getNumericValue(c.charAt(j))];
          // System.out.print(sum1+" ");
               sum1*=(int)Math.pow(aLen, cLen-1-j);
          // System.out.println(sum1);    
           sum=sum1+sum;
           }
           sum1=0;
           return sum;
       }
       else{
           result=1;
           for(int i=0;i<cLen;i++){
               if(i==0){
                   if(!hasZero || (B==1 && hasZero)){
                       result=result*(br[Character.getNumericValue(c.charAt(i))]);
                   }else{
                       result=result*(br[Character.getNumericValue(c.charAt(i))]-1);
                   }
               }else{
                   result=result*aLen;
               }
           }
           return result;
       }
      
        //return result+sum;    
       }
    public static void main(String[] args){
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	Scanner scan=new Scanner(System.in);
    	int n = scan.nextInt();
    	for(int i=0;i<n;i++){
    		al.add(scan.nextInt());
    	}
    	int b = scan.nextInt();
    	int c = scan.nextInt();
    	NumbersOfLength numbers = new NumbersOfLength();
    	System.out.println(numbers.solve(al, b, c));
    }

}
