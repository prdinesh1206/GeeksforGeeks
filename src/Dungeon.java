import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

	public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) {
	  
	    int ans = 1;
	    int m = a.size();
	    int n = a.get(0).size();
	    int[][] list = new int[m][n];
	    
	    int current, up, left;
	    list[0][0]=1;
	    for(int i=0;i<m;i++){
	        for(int j=0;j<n;j++){
	            current = a.get(i).get(j);
	            
	            up = isValid(m, n, i-1, j) ? list[i-1][j] : Integer.MAX_VALUE;
	            left = isValid(m, n, i, j-1) ? list[i][j-1] : Integer.MAX_VALUE;
	            if(up<left){
	                if(isValid(m, n, i-1, j))
	                    a.get(i).set(j, a.get(i-1).get(j)+current);
	                if(a.get(i).get(j)<0){
	                    if(isValid(m, n, i-1, j))
	                        list[i][j]=(Math.abs(1-a.get(i).get(j)))>list[i-1][j] ? (Math.abs(1-a.get(i).get(j)))  : list[i-1][j];
	                    else{
	                        list[i][j] = Math.abs(1-a.get(i).get(j));
	                    }     
	                }else{
	                    if(i!=0)
	                        list[i][j]=list[i-1][j];
	                }
	            }else{
	                if(isValid(m, n, i, j-1))
	                    a.get(i).set(j, a.get(i).get(j-1)+current);
	                if(a.get(i).get(j)<0){
	                    if(isValid(m, n, i, j-1))
	                        list[i][j]=(Math.abs(1-a.get(i).get(j)))>list[i][j-1] ? (Math.abs(1-a.get(i).get(j))) : list[i][j-1];
                        else{
                            list[i][j]=Math.abs(1-a.get(i).get(j));
                        }
	                }else{
	                    if(j!=0)
	                        list[i][j]=list[i][j-1];
	                }
	            }
	            
	        }
	    }
	    printList(list, m, n);
	  
	        return list[m-1][n-1];
	}
	public boolean isValid(int m, int n, int i, int j){
	    if(i<0 || j<0){
	        return false;
	    }
	    if(i>=m || j>=n){
	        return false;
	    }
	    return true;
	}
	public void printList(int[][] list, int m, int n){
	    for(int i=0;i<m;i++){
	        for(int j=0;j<n;j++){
	            System.out.print(list[i][j]+" ");
	        }
	        System.out.println();
	    }
	}

	public static void main(String[] args){
		Dungeon d = new Dungeon();
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int m = Integer.parseInt(line.split(" ")[0]);
		int n = Integer.parseInt(line.split(" ")[1]);
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		String[] s = line.split(" ");
		int c=0;
		for(int i=0;i<m;i++){
			ArrayList<Integer> al1 = new ArrayList<Integer>();
			for(int j=0;j<n;j++){
				al1.add(Integer.parseInt(s[2+(c++)]));
			}
			al.add(al1);
		}
		d.calculateMinimumHP(al);
	}

}
