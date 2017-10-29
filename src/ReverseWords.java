import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args){
		String input1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		Scanner scan = new Scanner(System.in);
		int l = Integer.parseInt(scan.nextLine());
		
		String[][]scores = new String[l][2];
		for(int i=0;i<l;i++){
			String[] input = scan.nextLine().split(" ");
			scores[i][0] = input[0];
			scores[i][1] = input[1];
		}
		System.out.println(bestAverageGrade(scores));
	        
	}
	static int bestAverageGrade(String[][] scores) {

        Map<String, Long> map = new HashMap<String, Long>();
        Map<String, Long> map_1 = new HashMap<String, Long>();
        
        int row = scores.length;
        int col = 2;
       
        for(int i=0;i<row;i++){
            if(map.get(scores[i][0])!=null){
                map.put(scores[i][0], map.get(scores[i][0])+Integer.parseInt(scores[i][1]));
            }else{
                map.put(scores[i][0], Long.parseLong(scores[i][1]));
            }
           
            if(map_1.get(scores[i][0])!=null){
                map_1.put(scores[i][0], map_1.get(scores[i][0])+1);
            }else{
                map_1.put(scores[i][0], (long) 1);
            }
           
        }
        
        Iterator it = map.entrySet().iterator();
        
        long max = Long.MIN_VALUE;
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            
            Long sum = (Long)pair.getValue();
            System.out.print(pair.getKey() +" "+sum+" ");
            Long count = (Long)map_1.get(pair.getKey());
            Long avg = Math.floorDiv(sum, count);
            System.out.println(avg);
            if(max<avg){
            	max = avg;
            }
        }
        return (int)max;

    }
}
