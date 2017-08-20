import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReverseString {

	public void reverseString(char[] s){
		StringBuffer temp;
		int start=0, end=0;
		for(int i=0;i<s.length;i++){
			
			if(s[i]!=' '){
				end=i;
			}else{
				
				reverseWord(s,start, end);
				start=i+1;
			}
		}
		reverseWord(s, start, end);

		
		reverseWord(s,0,s.length-1);
		String s2=new String(s);
		System.out.println(s2);
	}
	
	public void reverseWord(char[] s1, int i, int j){
		int t1=i, t2=j;
		char temp;
		while(t1<t2){
			temp=s1[t1];
			s1[t1]=s1[t2];
			s1[t2]=temp;
			t1++;
			t2--;
		}
	}
	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner scan=new Scanner(System.in);
		scan.nextLine();
		new ReverseString().reverseString("Hello world bye good bye".toCharArray());
	}
}
