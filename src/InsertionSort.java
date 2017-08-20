
public class InsertionSort {

	public static void main(String[] args){
		int[] arr={9, 7, 6, 15, 16, 5, 10, 11};
		
		int i,j, pivot;
		for(i=1;i<arr.length;i++){
			pivot=arr[i];
			j=i-1;
			while(j>=0&&arr[j]>pivot){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=pivot;
		}
		for(i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
