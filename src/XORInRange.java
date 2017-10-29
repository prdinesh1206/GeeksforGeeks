import java.util.Scanner;

public class XORInRange {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int l = Integer.parseInt(scan.nextLine());
		int r = Integer.parseInt(scan.nextLine());
//		for(int i=l;i<=r;i++)
//			System.out.println(Integer.toBinaryString(i));
		int xor = l^r;
		System.out.println(Integer.toBinaryString(xor));
		System.out.println(Integer.toBinaryString(l)+" "+Integer.toBinaryString(r));
		System.out.println(Integer.numberOfLeadingZeros(xor));
	}
	
}
