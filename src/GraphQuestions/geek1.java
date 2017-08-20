package GraphQuestions;

public class geek1{
	public static void main(String[] args){
		int[] a={1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
		int k=2,k1, count, maxcount=0, maxi=0;
		int i,j;
		for(i=0;i<a.length;i++){
			k1=k;
			count=0;
			for(j=i;j<a.length;j++){
				
				if(a[j]==0)
					if(k1==0)
					break;
				else
					k1--;
				count++;				
			}
			if(count>maxcount){
				maxcount=count;
				maxi=i;
			}
		}
	System.out.println(maxcount);	
	}
}