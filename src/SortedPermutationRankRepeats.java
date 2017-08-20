import java.util.Scanner;

public class SortedPermutationRankRepeats {

	public int findRank(String a) {
	    int[] check=new int[256];
	    int n=a.length();
	    long sum=0;
	    for(char ch: a.toCharArray()){
	        check[(int)ch]++;
	    }
	   // printCheck(check);
	    for(int i=0;i<n;i++){
	        char ch=a.charAt(i);
	        
	        long tempSum=0;
	        
	        for(int j=0;j<(int)ch&&j<256;j++){
	            if(check[j]!=0){
	                check[j]--;
	                //printCheck(check);
	                long num=factorial(n-1-i);
	                long den=getFactorialProd(check);
	                //System.out.println(num+" "+den);
	                tempSum+=(num/den);
	                check[j]++;
	            }
	           
	        }
	        check[(int) ch]--;
	         //System.out.println();
	        //System.out.println(tempSum);
	        sum=(sum+tempSum);//%1000003;
	    }
	    return (int)sum+1;
	}
	public void printCheck(int[] check){
	    for(int i=0;i<256;i++)
	        System.out.print(check[i]+" ");
	   System.out.println();
	}
	public long getFactorialProd(int[] check){
	    long product=1;
	    for(int i=0;i<256;i++){
	        if(check[i]!=0){
	            //System.out.print(check[i]+" ");
	            product=product*factorial(check[i]);
	        }
	    }
	    //System.out.println();
	    return product;
	}
	public long factorial(int n){
	    long fact=1;
	    for(int i=n;i>0;i--){
	        fact = (fact*i);
	    }
	    return fact;
	}
	public static void main(String[] args){
		SortedPermutationRankRepeats ss = new SortedPermutationRankRepeats();
		 //TestClass ss = new TestClass();
	        Scanner scan= new Scanner(System.in);
	        int loops=Integer.parseInt(scan.nextLine());
	        while(loops>0){
			    System.out.println(ss.findRank(scan.nextLine()));
	            loops--;
	            
	        }
	}
}
