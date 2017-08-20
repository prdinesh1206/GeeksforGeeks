
public class QuickSort {

  public void quickSort(int[] arr,int low,int high){
	  if(low<high)
	  {
	  int p=partition(arr,low,high);
	  quickSort(arr,low,p-1);
	  quickSort(arr,p+1,high);
	  }
  }
  public int partition(int[] arr, int low, int high){
	  int i=low-1,temp=0;
	  int pivot=arr[high];
	  
	  for(int j=low;j<high;j++){
		  if(arr[j]<=pivot){
			  i++;
			  temp=arr[j];
			  arr[j]=arr[i];
			  arr[i]=temp;
		  }
	  }
	  temp=arr[i+1];
	  arr[i+1]=arr[high];
	  arr[high]=temp;
	  return i+1;
	  
  }
	public static void main(String[] args){
		QuickSort q=new QuickSort();
		int[] arr={10, 7, 8, 9, 1, 5};
		int i=0;
		while(i<arr.length){
			System.out.print(arr[i++]+" ");
		}
		System.out.println();
		q.quickSort(arr, 0, arr.length-1);
		 i=0;
		while(i<arr.length){
			System.out.print(arr[i++]+" ");
		}
	}
}
