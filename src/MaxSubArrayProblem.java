
public class MaxSubArrayProblem{
public static int maxSubArraySum(int a[], int size)
{
int max_so_far = a[0];
int curr_max = a[0];
int start=0, end=0;
for (int i = 1; i < size; i++)
{
	//	curr_max = max(a[i], curr_max+a[i]);
		if(a[i]>curr_max+a[i]){
		  
		    curr_max=a[i];
		}else{
		    curr_max=curr_max+a[i];
		}
		if(max_so_far<curr_max){
		   
		    max_so_far=curr_max;
		}else{
		    max_so_far=max_so_far;
		}
	//	max_so_far = max(max_so_far, curr_max);
}
//System.out.println(start+" "+end);
return max_so_far;
}

/* Driver program to test maxSubArraySum */
public static void main(String[] args)
{
int a[] = {100, 1, 3, -1000, 1, 2, 3};
int n = a.length;
int max_sum = maxSubArraySum(a, n);
System.out.println("Maximum contiguous sum is " +max_sum);
}
}