import java.util.Arrays;

//Find the largest multiple of 3
public class Multiple3 {

	public static void main(String[] args){
		int[] input={8, 1, 7, 6, 0};
		
		
		int sum=0;
		boolean arType=true;
		Queue q1=new Queue(arType, input.length),q2=new Queue(arType, input.length),q3=new Queue(arType, input.length);
		for(int i=0;i<input.length;i++){
			sum+=input[i];
			if(input[i]%3==0){
				q1.push(arType, input[i]);
			}else if(input[i]%3==1){
				q2.push(arType, input[i]);
			}else if(input[i]%3==2){
				q3.push(arType, input[i]);
			}
		}
		
		if(sum%3==0){
			q1.printQ(arType);
			q2.printQ(arType);
			q3.printQ(arType);
			return;
		}else if(sum%3==1){
			if(q2.r!=-1)
			q2.pop(arType);
			
			else if(q3.r!=-1){
				q3.pop(arType);
				if(q3.r!=-1){
					q3.pop(arType);
				}else
					System.out.println("Not formed");
			}else
				System.out.println("Not formed");
		}else if(sum%3==2){
			if(q3.r!=-1)
				q3.pop(arType);
			
			else if(q2.r!=-1){
				q2.pop(arType);
				if(q2.r!=-1){
					q2.pop(arType);
				}else
					System.out.println("Not formed");
			}else
				System.out.println("Not formed");
		}
		q1.printQ(arType);
		System.out.println();
		q2.printQ(arType);
		System.out.println();
		q3.printQ(arType);
		System.out.println();
  }
	
}
