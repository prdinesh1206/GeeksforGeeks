import java.util.ArrayList;
import java.util.List;

public class MaxSubArrayProblem_Divide {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	    
	    int n=a.size();
	    if(n==1)
	    return a.get(0);
	    
	    List<Integer> left=new ArrayList<Integer>();
	    List<Integer> right=new ArrayList<Integer>();
	    
	    int mid=n/2;
	    
	    for(int i=0;i<mid;i++)
	    left.add(a.get(i));
	    
	    for(int i=mid;i<n;i++)
	    right.add(a.get(i));
	    
	    return Math.max(maxSubArray(left), Math.max(maxSubArray(right), maxViaMid(a, mid)));
	    
	    
	}
	public int maxViaMid(List<Integer> a, int mid){
	    int leftSum=0, rightSum=0;
	    int leftMax=a.get(mid-1);
	    int rightMax=a.get(mid);
	    
	    for(int i=mid-1;i>=0;i--){
	    leftSum+=a.get(i);
	    if(leftSum>leftMax){
	        leftMax=leftSum;
	    }
	    }
	    
	    for(int i=mid;i<a.size();i++){
	    rightSum+=a.get(i);
	    if(rightSum>rightMax){
	        rightMax=rightSum;
	    }
	    }
	    
	    return leftMax+rightMax;
	}
}
