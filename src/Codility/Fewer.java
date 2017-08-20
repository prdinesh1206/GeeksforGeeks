package Codility;

public class Fewer {

	public int solution(int[] A){

        // write your code in Java SE 8
        int length= A.length;
        int s=0,e=length-1,i,max,min;
        for(s=0;s<length-1;s++)
        {
            if(A[s]>A[s+1])
            {
                break;
            }
           
        }
        if(s==length-1)
        return 0;
        for(e=length-1;e>0;e--)
        {
            if(A[e]<A[e-1])
            break;
        }
        max=A[s];
        min=A[s];
        for(i=s+1;i<=e;i++)
        {
         if(A[i]>max)
         max=A[i];
         if(A[i]<min)
         min=A[i];
        }
        for(i=0;i<s;i++)
        {
            if(A[i]>min)
            {
                s=i;
                break;
            }
        }
        for(i=length-1;i>=e+1;i--)
        {
            if(A[i]<max)
            {
                e=i;
                break;
            }
        }
        return e-s+1;
  
	}
	public static void main(String[] args){
		int[] a={3,2,1, 6,4, 5, 7, 8, 9, 12, 11, 14, 13 };
		System.out.println(new Fewer().solution(a));
	}
}
