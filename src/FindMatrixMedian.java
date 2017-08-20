import java.util.ArrayList;
import java.util.Scanner;

public class FindMatrixMedian {

	public static void main(String[] args){
		FindMatrixMedian fin = new FindMatrixMedian();
		ArrayList<ArrayList<Integer>> A=new ArrayList<ArrayList<Integer>>();
		Scanner scan = new Scanner(System.in);
		int n, m;
		n=scan.nextInt();
		m=scan.nextInt();
		for(int i=0;i<n;i++){
			ArrayList<Integer>temp = new ArrayList<Integer>();
			for(int j=0;j<m;j++){
				temp.add(scan.nextInt());
			}
			A.add(temp);
		}
		/*for(int i=0;i<n;i++){
//			System.out.println(fin.findRowCount(A.get(i), 5));
		}*/
		fin.findMedian(A);
	}

	public int findMedian(ArrayList<ArrayList<Integer>> A) {
	      int n =A.size();
	      int m = A.get(0).size();
	      
	      int min=A.get(0).get(0), max=A.get(n-1).get(m-1), i;
	      for(i=0;i<n;i++){
	        if(min>A.get(i).get(0))
	            min=A.get(i).get(0);

	        if(max<A.get(i).get(m-1))
	            max=A.get(i).get(m-1);
	        }
	      int low=min, high = max,mid=0, want=n*m/2, count=0;
	      while(low<high){
	          mid=low+(high-low)/2;
	          count=0;
	          for(i=0;i<n;i++){
	             count=count+findRowCount(A.get(i),mid);
	          }
	          if(count<want+1){
	              low=mid+1;
	          }else{
	              high=mid;
	          }
	        System.out.println(low+" "+high+" "+mid+": "+count);
	      }
	      return low;
	    }
    public int findRowCount(ArrayList<Integer> a, int want){
        int low=0, high=a.size()-1, mid=-1, ans=-1;
        if(a.get(0)>want)
            return 0;
        /*if(a.get(high)<=want)
            return high+1;*/
        while(low<=high){
            mid=(low+high)/2;
            if(a.get(low)>want)
            	break;
            if(a.get(mid)>want){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
                ans=mid;
            }
        }
        return low;
    }

}
