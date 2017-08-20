//Maximum of all subarrays of size k (Added a O(n) method)
public class MaxOfSub {

	public static void main(String[] args){
		int[] arr={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		int max=Integer.MIN_VALUE;
		int k=4, i=0;
		while(i<k){
			if(max<arr[i])
				max=arr[i];
			i++;
		}
		System.out.print(max+" ");
		if(arr.length>k){
			for(i=k;i<arr.length;i++){
				if(max<arr[i]){
					max=arr[i];
				}
				System.out.print(max+" ");
			}
		}
		
		
		
	}
}
